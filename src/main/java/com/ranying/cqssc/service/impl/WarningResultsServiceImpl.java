package com.ranying.cqssc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ranying.cqssc.constant.LotteryConstant;
import com.ranying.cqssc.service.WarningResultsService;
import com.ranying.cqssc.dao.LotteryRecordDAO;
import com.ranying.cqssc.dao.WarningResultDAO;
import com.ranying.cqssc.entity.LotteryParam;
import com.ranying.cqssc.entity.LotteryRecord;
import com.ranying.cqssc.entity.WarningResult;
import com.ranying.cqssc.query.WarningResultQuery;
import com.ranying.cqssc.service.ParamService;
import com.ranying.cqssc.vo.GenerateVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class WarningResultsServiceImpl implements WarningResultsService {

    @Resource
    private WarningResultDAO warningResultDAO;

    @Resource
    private ParamService paramService;

    @Resource
    private LotteryRecordDAO lotteryRecordDAO;

    @Override
    public PageInfo<WarningResult> listResult(WarningResultQuery query) {
        PageHelper.startPage(query.getPageNumber(), query.getPageSize());
        List<WarningResult> list = warningResultDAO.list(query);
        PageInfo<WarningResult> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void statisticsWarning() {
        List<LotteryParam> params = paramService.list();
        if (params.isEmpty()) {
            return;
        }
        LotteryRecord lotteryRecord = new LotteryRecord();
        lotteryRecord.setWarningStatisticFlag(0);
        List<LotteryRecord> lotteryRecords = lotteryRecordDAO.list(lotteryRecord);
        for (LotteryRecord record : lotteryRecords) {
            LotteryRecord updateRecord = new LotteryRecord();
            updateRecord.setExpect(record.getExpect());
            updateRecord.setWarningStatisticFlag(1);
            lotteryRecordDAO.updateByPrimaryKeySelective(updateRecord);
            for (LotteryParam lotteryParam : params) {

                List<String> queryList = lotteryParam.getNumberList();

                //位置一  万千百
                List<GenerateVO> list = lotteryRecordDAO.queryWaringResult(queryList, LotteryConstant.Arrange.WQB.getValue(), record.getExpect());
                this.processWarningResult(lotteryParam,record, list ,LotteryConstant.Arrange.WQB);

                //位置二 万千十
                list = lotteryRecordDAO.queryGenerate(queryList, LotteryConstant.Arrange.WQS.getValue());
                this.processWarningResult(lotteryParam,record, list ,LotteryConstant.Arrange.WQS);

                //位置三 万千个
                list = lotteryRecordDAO.queryGenerate(queryList, LotteryConstant.Arrange.WQG.getValue());
                this.processWarningResult(lotteryParam,record, list ,LotteryConstant.Arrange.WQG);

                //位置四 万百十
                list = lotteryRecordDAO.queryGenerate(queryList, LotteryConstant.Arrange.WBS.getValue());
                this.processWarningResult(lotteryParam,record, list ,LotteryConstant.Arrange.WBS);

                //位置五 万百个
                list = lotteryRecordDAO.queryGenerate(queryList, LotteryConstant.Arrange.WBG.getValue());
                this.processWarningResult(lotteryParam,record, list ,LotteryConstant.Arrange.WBG);

                //位置六 万十个
                list = lotteryRecordDAO.queryGenerate(queryList, LotteryConstant.Arrange.WSG.getValue());
                this.processWarningResult(lotteryParam,record, list ,LotteryConstant.Arrange.WSG);

                //位置七 千百十
                list = lotteryRecordDAO.queryGenerate(queryList, LotteryConstant.Arrange.QBS.getValue());
                this.processWarningResult(lotteryParam,record, list ,LotteryConstant.Arrange.QBS);

                //位置八 千百个
                list = lotteryRecordDAO.queryGenerate(queryList, LotteryConstant.Arrange.QBG.getValue());
                this.processWarningResult(lotteryParam,record, list ,LotteryConstant.Arrange.QBG);

                //位置九 千十个
                list = lotteryRecordDAO.queryGenerate(queryList, LotteryConstant.Arrange.QSG.getValue());
                this.processWarningResult(lotteryParam,record, list ,LotteryConstant.Arrange.QSG);

                //位置十 百十个
                list = lotteryRecordDAO.queryGenerate(queryList, LotteryConstant.Arrange.BSG.getValue());
                this.processWarningResult(lotteryParam,record, list ,LotteryConstant.Arrange.BSG);
            }
        }
    }

    private void processWarningResult(LotteryParam lotteryParam,LotteryRecord record, List<GenerateVO> list ,LotteryConstant.Arrange location) {

        if (list != null && list.size() > 1) {
            // 如果这一期有中奖
            String expect1 = list.get(0).getLatestExpect();
            if (expect1.equals(record.getExpect())) {
                String expect2 = list.get(1).getLatestExpect();
                int period = lotteryRecordDAO.countBetweenPeriod(expect2, expect1) -1;
                Integer warning = lotteryParam.getLocationWarning(location);
                if (warning * 0.4 < period) {
                    WarningResult warningResult = new WarningResult();
                    warningResult.setParamId(lotteryParam.getId());
                    warningResult.setParamName(lotteryParam.getName());
                    warningResult.setParamNumbers(lotteryParam.getNumbers());
                    warningResult.setParamAmount(lotteryParam.getAmount());
                    warningResult.setLocation(location.getName());
                    warningResult.setResultPeriod(period - (int)Math.ceil(warning * 0.4));
                    warningResult.setCurrentExpect(record.getExpect());
                    warningResult.setLastExpect(expect2);
                    warningResultDAO.insert(warningResult);
                }
            }
        }

    }

}
