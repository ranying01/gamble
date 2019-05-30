package com.ranying.syxw.entity;

import java.util.Date;

public class SyxwLotteryBaseRecord {

    /**
     * 彩票期数
     */
    private String expect;

    /**
     * 开奖号码1
     */
    private String opencode1;

    /**
     * 开奖号码2
     */
    private String opencode2;

    /**
     * 开奖号码3
     */
    private String opencode3;

    /**
     * 开奖号码4
     */
    private String opencode4;

    /**
     * 开奖号码5
     */
    private String opencode5;

    /**
     * 开奖时间
     */
    private Date opentime;

    /**
     * 开奖时间戳
     */
    private Long opentimestamp;

    /**
     * 是否已经统计  1：已经统计  0 ：未统计
     */
    private Integer warningStatisticFlag;

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getOpencode1() {
        return opencode1;
    }

    public void setOpencode1(String opencode1) {
        this.opencode1 = opencode1;
    }

    public String getOpencode2() {
        return opencode2;
    }

    public void setOpencode2(String opencode2) {
        this.opencode2 = opencode2;
    }

    public String getOpencode3() {
        return opencode3;
    }

    public void setOpencode3(String opencode3) {
        this.opencode3 = opencode3;
    }

    public String getOpencode4() {
        return opencode4;
    }

    public void setOpencode4(String opencode4) {
        this.opencode4 = opencode4;
    }

    public String getOpencode5() {
        return opencode5;
    }

    public void setOpencode5(String opencode5) {
        this.opencode5 = opencode5;
    }

    public Date getOpentime() {
        return opentime;
    }

    public void setOpentime(Date opentime) {
        this.opentime = opentime;
    }

    public Long getOpentimestamp() {
        return opentimestamp;
    }

    public void setOpentimestamp(Long opentimestamp) {
        this.opentimestamp = opentimestamp;
    }

    public Integer getWarningStatisticFlag() {
        return warningStatisticFlag;
    }

    public void setWarningStatisticFlag(Integer warningStatisticFlag) {
        this.warningStatisticFlag = warningStatisticFlag;
    }
}
