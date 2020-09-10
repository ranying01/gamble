package com.ranying.cqssc.service.impl;

import com.ranying.cqssc.service.SyxwWarningService;
import com.ranying.syxw.dao.SyxwLotteryParamDAO;
import com.ranying.syxw.entity.SyxwLotteryParam;
import com.ranying.syxw.query.SyxwParamQuery;
import com.ranying.syxw.service.SyxwSyncDataService;
import com.ranying.syxw.vo.SyxwGenerateRow;
import com.ranying.syxw.vo.SyxwWarningRow;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class SyxwWarningServiceImpl implements SyxwWarningService {

    @Resource
    private SyxwLotteryParamDAO syxwLotteryParamDAO;

    @Resource
    private SyxwSyncDataService syxwSyncDataService;

    @Override
    public List<SyxwWarningRow> listWarning(SyxwParamQuery query) {

        List<SyxwLotteryParam> paramList = syxwLotteryParamDAO.listByQuery(query);
        if (paramList.isEmpty()) {
            return null;
        }
        List<SyxwWarningRow> rows = new ArrayList<>();
        for (SyxwLotteryParam lotteryParam : paramList) {
            List<SyxwGenerateRow> list = syxwSyncDataService.generate(lotteryParam);
            for (SyxwGenerateRow generateRow : list) {
                if (generateRow.getWaringFlag() == 1) {
                    SyxwWarningRow warningRow = new SyxwWarningRow();
                    warningRow.setId(lotteryParam.getId());
                    warningRow.setMaxNeglect(generateRow.getMaxNeglect());
                    warningRow.setNumbers(lotteryParam.getNumbers());
                    warningRow.setPeriod(generateRow.getPeriod());
                    warningRow.setAmount(lotteryParam.getAmount());
                    warningRow.setParamName(lotteryParam.getName());
                    warningRow.setType(lotteryParam.getType());
                    rows.add(warningRow);
                }
            }
        }
        return rows;
    }
}
