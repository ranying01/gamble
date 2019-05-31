package com.ranying.cqssc.service.impl;

import com.ranying.cqssc.service.WarningService;
import com.ranying.cqssc.dao.LotteryParamDAO;
import com.ranying.cqssc.entity.LotteryParam;
import com.ranying.cqssc.service.SyncDataService;
import com.ranying.cqssc.vo.GenerateRow;
import com.ranying.cqssc.vo.WarningRow;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class WarningServiceImpl implements WarningService {

    @Resource
    private SyncDataService syncDataService;

    @Resource
    private LotteryParamDAO lotteryParamDAO;

    @Override
    public List<WarningRow> listWarning() {
        List<LotteryParam> paramList = lotteryParamDAO.findAll();
        if (paramList.isEmpty()) {
            return null;
        }
        List<WarningRow> rows = new ArrayList<>();
        for (LotteryParam lotteryParam : paramList) {
            List<GenerateRow> list = syncDataService.generate(lotteryParam);
            for (GenerateRow generateRow : list) {
                if (generateRow.getWaringFlag() ==1) {
                    WarningRow warningRow = new WarningRow();
                    warningRow.setId(lotteryParam.getId());
                    warningRow.setLocation(generateRow.getLocation());
                    warningRow.setMaxNeglect(generateRow.getMaxNeglect());
                    warningRow.setNumbers(lotteryParam.getNumbers());
                    warningRow.setPeriod(generateRow.getPeriod());
                    warningRow.setAmount(lotteryParam.getAmount());
                    warningRow.setParamName(lotteryParam.getName());
                    rows.add(warningRow);
               }
            }
        }
        Collections.sort(rows);
        /*rows.sort(new Comparator<WarningRow>(){
            @Override
            public int compare(WarningRow o1, WarningRow o2) {
                return LotteryConstant.Arrange.sortMap.get(o1.getLocation()).compareTo(LotteryConstant.Arrange.sortMap.get(o2.getLocation()));
            }
        });*/
        return rows;
    }
}
