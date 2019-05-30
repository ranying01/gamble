package com.ranying.syxw.vo;

import com.ranying.syxw.entity.SyxwLotteryParam;

import java.io.Serializable;
import java.util.List;

public class SyxwGenerateResultVO implements Serializable {

    private List<SyxwGenerateRow> GenerateRows;

    private SyxwLotteryParam lotteryParam;

    public List<SyxwGenerateRow> getGenerateRows() {
        return GenerateRows;
    }

    public void setGenerateRows(List<SyxwGenerateRow> generateRows) {
        GenerateRows = generateRows;
    }

    public SyxwLotteryParam getLotteryParam() {
        return lotteryParam;
    }

    public void setLotteryParam(SyxwLotteryParam lotteryParam) {
        this.lotteryParam = lotteryParam;
    }
}
