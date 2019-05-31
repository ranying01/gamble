package com.ranying.syxw.vo;

import java.io.Serializable;

public class SyxwWarningRow implements Serializable {

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

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
