package com.ranying.cqssc.vo;

import com.ranying.cqssc.constant.LotteryConstant;

import java.io.Serializable;

public class WarningRow implements Serializable,Comparable<WarningRow>{

    private Integer id;

    /**
     * 名称
     */
    private String paramName;

    /**
     * 数量
     */
    private Integer amount;

    /**
     * 历史最大遗漏
     */
    private Integer maxNeglect;

    /**
     * 当前遗留
     */
    private Integer period;

    /**
     * 号码
     */
    private String numbers;

    /**
     * 位置
     */
    private String location;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getMaxNeglect() {
        return maxNeglect;
    }

    public void setMaxNeglect(Integer maxNeglect) {
        this.maxNeglect = maxNeglect;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(WarningRow o) {
        // return o.getLocation().compareTo(this.getLocation());
        return LotteryConstant.Arrange.sortMap.get(this.getLocation()).compareTo(LotteryConstant.Arrange.sortMap.get(o.getLocation()));
    }
}
