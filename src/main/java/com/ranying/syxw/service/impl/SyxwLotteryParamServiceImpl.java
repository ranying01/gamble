package com.ranying.syxw.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ranying.common.PageParam;
import com.ranying.syxw.constant.SyxwConstant;
import com.ranying.syxw.dao.SyxwLotteryParamDAO;
import com.ranying.syxw.dao.SyxwLotteryRecordBaseDAO;
import com.ranying.syxw.entity.SyxwLotteryBaseRecord;
import com.ranying.syxw.entity.SyxwLotteryParam;
import com.ranying.syxw.query.SyxwLotteryRecordQuery;
import com.ranying.syxw.query.SyxwParamQuery;
import com.ranying.syxw.service.SyxwLotteryParamService;
import com.ranying.syxw.service.SyxwSyncDataService;
import com.ranying.syxw.vo.SyxwGenerateResultVO;
import com.ranying.syxw.vo.SyxwGenerateRow;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 */
@Service
public class SyxwLotteryParamServiceImpl implements SyxwLotteryParamService {

    @Resource
    private SyxwLotteryParamDAO syxwLotteryParamDAO;

    @Resource
    private SyxwSyncDataService syxwSyncDataService;

    @Resource
    private SyxwLotteryRecordBaseDAO syxwLotteryRecordBaseDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(SyxwLotteryParam lotteryParam) {
        Map<String, SyxwConstant.LotteryType> map = SyxwConstant.SYXW_TYPE_MAP;
        for (Map.Entry<String, SyxwConstant.LotteryType> entry : map.entrySet()) {
            lotteryParam.setType(entry.getKey());
            this.save(lotteryParam);
        }
    }

    @Override
    public PageInfo<SyxwLotteryParam> list(SyxwParamQuery query, PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNumber(), pageParam.getPageSize());
        List<SyxwLotteryParam> list = syxwLotteryParamDAO.listByQuery(query);
        PageInfo<SyxwLotteryParam> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void save(SyxwLotteryParam lotteryParam) {
        if (lotteryParam == null) {
            return;
        }
        lotteryParam.setName(lotteryParam.getName().trim());
        lotteryParam.setNumbers(lotteryParam.getNumbers().trim());
        SyxwParamQuery query = new SyxwParamQuery();
        lotteryParam.setAmount(lotteryParam.getNumbers().split(",").length);
        query.setType(lotteryParam.getType());
        query.setName(lotteryParam.getName());
        List<SyxwLotteryParam> list = syxwLotteryParamDAO.listByQuery(query);
        if (!list.isEmpty()) {
            throw new RuntimeException("存在名称" + lotteryParam.getName());
        }
        query = new SyxwParamQuery();
        query.setNumbers(lotteryParam.getName());
        list = syxwLotteryParamDAO.listByQuery(query);
        if (!list.isEmpty()) {
            throw new RuntimeException("存在数据:" + lotteryParam.getNumbers());
        }
        syxwLotteryParamDAO.insert(lotteryParam);
    }

    @Override
    public void delete(Integer id) {
        syxwLotteryParamDAO.deleteByPrimaryKey(id);
    }

    @Override
    public List<SyxwLotteryParam> list(SyxwParamQuery syxwParamQuery) {
        return syxwLotteryParamDAO.listByQuery(syxwParamQuery);
    }

    @Override
    public SyxwGenerateResultVO analyze(Integer id) {
        SyxwGenerateResultVO syxwGenerateResultVO = new SyxwGenerateResultVO();
        SyxwLotteryParam syxwLotteryParam = syxwLotteryParamDAO.selectByPrimaryKey(id);

        SyxwLotteryRecordQuery syxwLotteryQuery = new SyxwLotteryRecordQuery();

        syxwLotteryQuery.setCodesList(syxwLotteryParam.getCodes());
        syxwLotteryQuery.setTable(syxwSyncDataService.getTableName(syxwLotteryParam.getType()));

        Calendar calendar = Calendar.getInstance();
        syxwLotteryQuery.setEnd(calendar.getTime());
        calendar.add(Calendar.DATE, -30); // -30天
        syxwLotteryQuery.setBegin(calendar.getTime());
        List<SyxwLotteryBaseRecord> list30 = syxwLotteryRecordBaseDAO.list(syxwLotteryQuery);

        syxwLotteryQuery.setEnd(calendar.getTime());
        calendar.add(Calendar.DATE, -30); // -60天
        syxwLotteryQuery.setBegin(calendar.getTime());
        List<SyxwLotteryBaseRecord> list60 = syxwLotteryRecordBaseDAO.list(syxwLotteryQuery);

        syxwLotteryQuery.setEnd(calendar.getTime());
        calendar.add(Calendar.DATE, -30); // -90天
        syxwLotteryQuery.setBegin(calendar.getTime());
        List<SyxwLotteryBaseRecord> list90 = syxwLotteryRecordBaseDAO.list(syxwLotteryQuery);

        List<SyxwLotteryBaseRecord> list = new ArrayList<>();
        list.addAll(list30);
        list.addAll(list60);
        list.addAll(list90);

        SyxwGenerateRow syxwGenerateRow = new SyxwGenerateRow();
        if (list.isEmpty() || list.size() < 2) {
            syxwGenerateRow.setMaxNeglect(syxwLotteryParam.getMaxNeglect());
            syxwGenerateRow.setWaringFlag(1);
        } else {
            SyxwLotteryBaseRecord record = list.get(0);
            int period = syxwLotteryRecordBaseDAO.searchPeriod(syxwLotteryQuery.getTable(), record.getExpect(), list.get(1).getExpect());
            syxwGenerateRow.setLatestExpect(record.getExpect());
            syxwGenerateRow.setMaxNeglect(syxwLotteryParam.getMaxNeglect());
            syxwGenerateRow.setPeriod(period);
            syxwGenerateRow.setWaringFlag(Math.floor(syxwLotteryParam.getMaxNeglect() * 0.4) <= period ? 1 : 0);

            int[] rang1 = new int[]{0, 0, 0};
            int[] rang2 = new int[]{0, 0, 0};
            int[] rang3 = new int[]{0, 0, 0};

            for (int i = 1; i < list30.size(); i++) {
                period = syxwLotteryRecordBaseDAO.searchPeriod(syxwLotteryQuery.getTable(), list.get(i - 1).getExpect(), list.get(i).getExpect());
                if (period < 10) {
                    rang1[0]++;
                    rang2[0]++;
                    rang3[0]++;
                } else if (period < 15) {
                    rang1[1]++;
                    rang2[1]++;
                    rang3[1]++;
                } else {
                    rang1[2]++;
                    rang2[2]++;
                    rang3[2]++;
                }
            }

            for (int i = 1; i < list60.size(); i++) {
                period = syxwLotteryRecordBaseDAO.searchPeriod(syxwLotteryQuery.getTable(), list.get(i - 1).getExpect(), list.get(i).getExpect());
                if (period < 10) {
                    rang2[0]++;
                    rang3[0]++;
                } else if (period < 15) {
                    rang2[1]++;
                    rang3[1]++;
                } else {
                    rang2[2]++;
                    rang3[2]++;
                }
            }

            for (int i = 1; i < list90.size(); i++) {
                period = syxwLotteryRecordBaseDAO.searchPeriod(syxwLotteryQuery.getTable(), list.get(i - 1).getExpect(), list.get(i).getExpect());
                if (period < 10) {
                    rang3[0]++;
                } else if (period < 15) {
                    rang3[1]++;
                } else {
                    rang3[2]++;
                }
            }
            syxwGenerateResultVO.setRang1(rang1);
            syxwGenerateResultVO.setRang2(rang2);
            syxwGenerateResultVO.setRang3(rang3);
        }
        syxwGenerateResultVO.setGenerateRow(syxwGenerateRow);
        syxwGenerateResultVO.setLotteryParam(syxwLotteryParam);
        return syxwGenerateResultVO;
    }

    @Override
    public SyxwLotteryParam getEntity(Integer id) {
        return syxwLotteryParamDAO.selectByPrimaryKey(id);
    }

    @Override
    public void update(SyxwLotteryParam syxwLotteryParam) {
        Integer maxNeglect = syxwLotteryParam.getMaxNeglect();
        SyxwLotteryParam updateParam = new SyxwLotteryParam();
        updateParam.setId(syxwLotteryParam.getId());
        updateParam.setMaxNeglect(maxNeglect);
        syxwLotteryParamDAO.updateByPrimaryKeySelective(updateParam);
    }


}
