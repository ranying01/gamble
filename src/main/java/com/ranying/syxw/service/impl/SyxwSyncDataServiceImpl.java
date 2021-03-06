package com.ranying.syxw.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ranying.syxw.constant.SyxwConstant;
import com.ranying.syxw.dao.*;
import com.ranying.syxw.entity.SyxwLotteryBaseRecord;
import com.ranying.syxw.entity.SyxwLotteryParam;
import com.ranying.syxw.query.SyxwLotteryRecordQuery;
import com.ranying.syxw.service.SyxwSyncDataService;
import com.ranying.syxw.vo.SyxwGenerateRow;
import com.ranying.syxw.vo.SyxwMaxNeglectResult;
import com.ranying.util.DateFormat;
import com.ranying.util.EmailTool;
import com.ranying.util.HttpClientUtil;
import com.ranying.util.SimpleMailParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SyxwSyncDataServiceImpl implements SyxwSyncDataService {

    private Logger logger = LoggerFactory.getLogger(SyxwSyncDataServiceImpl.class);

    @Value("${gdsyxw.api}")
    private String gdSyxwUrl;

    @Value("${shsyxw.api}")
    private String shSyxwUrl;

    @Value("${jssyxw.api}")
    private String jsSyxwUrl;

    @Value("${jxsyxw.api}")
    private String jxSyxwUrl;

    @Value("${sdsyxw.api}")
    private String sdSyxwUrl;

    @Resource
    private EmailTool emailTool;

    @Resource
    private SyxwLotteryRecordBaseDAO syxwLotteryRecordBaseDAO;

    @Override
    public SyxwLotteryRecordQuery getSyxwLotteryRecordQuery(SyxwLotteryParam lotteryParam) {
        SyxwLotteryRecordQuery syxwLotteryQuery = new SyxwLotteryRecordQuery();
        // List<String[]> queryList = lotteryParam.getNumberList();
        // syxwLotteryQuery.setLotteryNumbers(queryList);
        syxwLotteryQuery.setCodesList(lotteryParam.getCodes());
        syxwLotteryQuery.setTable(this.getTableName(lotteryParam.getType()));
        syxwLotteryQuery.setLimit(2);
        return syxwLotteryQuery;
    }


    @Override
    public String getTableName(String type) {

        if (SyxwConstant.LotteryType.GD.getValue().equals(type)) {
            return "syxw_gd_lottery_record";
        }
        if (SyxwConstant.LotteryType.SH.getValue().equals(type)) {
            return "syxw_sh_lottery_record";
        }
        if (SyxwConstant.LotteryType.JX.getValue().equals(type)) {
            return "syxw_jx_lottery_record";
        }
        if (SyxwConstant.LotteryType.JS.getValue().equals(type)) {
            return "syxw_js_lottery_record";
        }
        if (SyxwConstant.LotteryType.SD.getValue().equals(type)) {
            return "syxw_sd_lottery_record";
        }
        throw new RuntimeException("找不到对应的类型");
    }

    private String getSyncUrl(SyxwConstant.LotteryType type) {
        if (SyxwConstant.LotteryType.GD.equals(type)) {
            return gdSyxwUrl;
        }
        if (SyxwConstant.LotteryType.SH.equals(type)) {
            return shSyxwUrl;
        }
        if (SyxwConstant.LotteryType.JX.equals(type)) {
            return jxSyxwUrl;
        }
        if (SyxwConstant.LotteryType.JS.equals(type)) {
            return jsSyxwUrl;
        }
        if (SyxwConstant.LotteryType.SD.equals(type)) {
            return sdSyxwUrl;
        }
        return null;
    }

    @Override
    public List<SyxwGenerateRow> generate(SyxwLotteryParam lotteryParam) {
        List<SyxwGenerateRow> rows = new ArrayList<>();
        SyxwLotteryRecordQuery syxwLotteryQuery = this.getSyxwLotteryRecordQuery(lotteryParam);
        List<SyxwLotteryBaseRecord> list = syxwLotteryRecordBaseDAO.list(syxwLotteryQuery);
        SyxwGenerateRow syxwGenerateRow = new SyxwGenerateRow();
        if (list.isEmpty()) {
            syxwGenerateRow.setLatestExpect(null);
            syxwGenerateRow.setMaxNeglect(lotteryParam.getMaxNeglect());
            syxwGenerateRow.setPeriod(null);
            syxwGenerateRow.setWaringFlag(1);
        } else {
            SyxwLotteryBaseRecord record = list.get(0);
            int period = syxwLotteryRecordBaseDAO.countPeriod(syxwLotteryQuery.getTable(), record.getExpect());
            syxwGenerateRow.setLatestExpect(record.getExpect());
            syxwGenerateRow.setMaxNeglect(lotteryParam.getMaxNeglect());
            syxwGenerateRow.setPeriod(period);
            syxwGenerateRow.setWaringFlag(Math.floor(lotteryParam.getMaxNeglect() * 0.4) <= period ? 1 : 0);
        }
        rows.add(syxwGenerateRow);
        return rows;
    }

    @Override
    public void sync(SyxwConstant.LotteryType type, Date date) {
        String dateStr = DateFormat.dateFormateBriefYmd(date);
        String url = this.getSyncUrl(type) + "&date=" + dateStr;
        logger.info("type" + type);
        logger.info("url" + url);
        String resultStr = HttpClientUtil.doGet(url);
        logger.info("resultStr:" + resultStr);
        try {
            List<SyxwLotteryBaseRecord> records = this.getRecords(resultStr, type);
            if (records != null) {
                syxwLotteryRecordBaseDAO.batchInsert(this.getTableName(type.getValue()), records);
            }
        } catch (Exception e) {
            SimpleMailParam simpleMail = new SimpleMailParam("彩票接口异常警告", type.getName() + "彩票结果同步异常，" + resultStr + "请知悉 , 错误" + e.getMessage());
            emailTool.sendSimpleMail(simpleMail);
        }
    }

    @Override
    public SyxwMaxNeglectResult searchMaxNeglect(String type, String numbers) {

        SyxwMaxNeglectResult result = new SyxwMaxNeglectResult();
        SyxwLotteryParam lotteryParam = new SyxwLotteryParam();
        lotteryParam.setType(type);
        lotteryParam.setNumbers(numbers);
        SyxwLotteryRecordQuery query = this.getSyxwLotteryRecordQuery(lotteryParam);
        query.setLimit(null);
        List<SyxwLotteryBaseRecord> list = syxwLotteryRecordBaseDAO.list(query);
        String maxExpect = syxwLotteryRecordBaseDAO.searchMaxExpect(query.getTable());
        if (list.isEmpty()) {
            return null;
        }
        int maxPeriod = 0;
        if (list.size() > 1) {
            maxPeriod = syxwLotteryRecordBaseDAO.searchPeriod(query.getTable(), maxExpect, list.get(0).getExpect());
        }
        if (list.size() > 2) {
            for (int i = 2; i < list.size(); i++) {
                int period = syxwLotteryRecordBaseDAO.searchPeriod(query.getTable(), list.get(i - 1).getExpect(), list.get(i).getExpect());
                if (period > maxPeriod) {
                    maxPeriod = period;
                    result.setExpect(list.get(i - 1).getExpect());
                    result.setPreExpect(list.get(i).getExpect());
                }
            }
        }
        result.setMaxNeglect(maxPeriod);
        return result;
    }

    private List<SyxwLotteryBaseRecord> getRecords(String resultStr, SyxwConstant.LotteryType type) {

        List<SyxwLotteryBaseRecord> records = new ArrayList<>();
        JSONObject jsonObject = JSONObject.parseObject(resultStr);
        if (jsonObject == null) {
            return null;
        }
        Set<String> keySet = jsonObject.keySet();
        for (String key : keySet) {
            JSONObject obj = (JSONObject) jsonObject.get(key);
            SyxwLotteryBaseRecord lotteryRecord = new SyxwLotteryBaseRecord();
            lotteryRecord.setExpect(key);
            String opencode = obj.getString("number");
            String[] numbers = opencode.split(",");
            lotteryRecord.setOpencode1(numbers[0]);
            lotteryRecord.setOpencode2(numbers[1]);
            lotteryRecord.setOpencode3(numbers[2]);
            lotteryRecord.setOpencode4(numbers[3]);
            lotteryRecord.setOpencode5(numbers[4]);
            lotteryRecord.setOpentime(obj.getDate("dateline"));
            lotteryRecord.setOpentimestamp(lotteryRecord.getOpentime().getTime());
            lotteryRecord.setWarningStatisticFlag(0);
            Arrays.sort(numbers);
            lotteryRecord.setCodes(numbers[0] + "," + numbers[1] + "," + numbers[2] + "," + numbers[3] + "," + numbers[4]);
            records.add(lotteryRecord);
        }
        return records;
    }
}
