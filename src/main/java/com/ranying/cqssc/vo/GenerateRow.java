package com.ranying.cqssc.vo;

public class GenerateRow {

    /**
     * 最近一期
     */
    private String latestExpect;

    /**
     * 过了多少期
     */
    private Integer period;

    /**
     * 位置
     */
    private String location;

    private Integer times;

    /**
     * 历史最大遗漏
     */
    private Integer maxNeglect;

    /**
     * 是否预警
     */
    private Integer waringFlag;

    public String getLatestExpect() {
        return latestExpect;
    }

    public void setLatestExpect(String latestExpect) {
        this.latestExpect = latestExpect;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getWaringFlag() {
        return waringFlag;
    }

    public void setWaringFlag(Integer waringFlag) {
        this.waringFlag = waringFlag;
    }

    public Integer getMaxNeglect() {
        return maxNeglect;
    }

    public void setMaxNeglect(Integer maxNeglect) {
        this.maxNeglect = maxNeglect;
    }
}
