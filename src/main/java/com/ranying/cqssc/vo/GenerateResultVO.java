package com.ranying.cqssc.vo;

import com.ranying.cqssc.entity.LotteryParam;

import java.io.Serializable;
import java.util.List;

public class GenerateResultVO implements Serializable {

    private List<GenerateRow> GenerateRows;

    private LotteryParam lotteryParam;

    public List<GenerateRow> getGenerateRows() {
        return GenerateRows;
    }

    public void setGenerateRows(List<GenerateRow> generateRows) {
        GenerateRows = generateRows;
    }

    public LotteryParam getLotteryParam() {
        return lotteryParam;
    }

    public void setLotteryParam(LotteryParam lotteryParam) {
        this.lotteryParam = lotteryParam;
    }
}
