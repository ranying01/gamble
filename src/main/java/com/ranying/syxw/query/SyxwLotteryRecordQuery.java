package com.ranying.syxw.query;

import java.io.Serializable;
import java.util.List;

public class SyxwLotteryRecordQuery implements Serializable {

    private String table;

    private Integer expect;

    // private String[] lotteryNumbers;

    private List<String[]> lotteryNumbers;

    private List<String> codesList;

    private Integer limit;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getExpect() {
        return expect;
    }

    public void setExpect(Integer expect) {
        this.expect = expect;
    }

    public List<String[]> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public void setLotteryNumbers(List<String[]> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<String> getCodesList() {
        return codesList;
    }

    public void setCodesList(List<String> codesList) {
        this.codesList = codesList;
    }
}
