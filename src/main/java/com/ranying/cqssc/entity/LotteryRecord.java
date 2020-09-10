package com.ranying.cqssc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * lottery_record
 * @author 
 */
public class LotteryRecord implements Serializable {
    
    /**
     * 彩票期数
     */
    private String expect;

    /**
     * 开奖号码1
     */
    private Integer opencode1;

    /**
     * 开奖号码2
     */
    private Integer opencode2;

    /**
     * 开奖号码3
     */
    private Integer opencode3;

    /**
     * 开奖号码4
     */
    private Integer opencode4;

    /**
     * 开奖号码5
     */
    private Integer opencode5;

    /**
     * 开奖时间
     */
    private Date opentime;

    /**
     * 开奖时间戳
     */
    private Long opentimestamp;

    /**
     * 是否已经统计
     */
    private Integer warningStatisticFlag;

    private static final long serialVersionUID = 1L;

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public Integer getOpencode1() {
        return opencode1;
    }

    public void setOpencode1(Integer opencode1) {
        this.opencode1 = opencode1;
    }

    public Integer getOpencode2() {
        return opencode2;
    }

    public void setOpencode2(Integer opencode2) {
        this.opencode2 = opencode2;
    }

    public Integer getOpencode3() {
        return opencode3;
    }

    public void setOpencode3(Integer opencode3) {
        this.opencode3 = opencode3;
    }

    public Integer getOpencode4() {
        return opencode4;
    }

    public void setOpencode4(Integer opencode4) {
        this.opencode4 = opencode4;
    }

    public Integer getOpencode5() {
        return opencode5;
    }

    public void setOpencode5(Integer opencode5) {
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LotteryRecord other = (LotteryRecord) that;
        return (this.getExpect() == null ? other.getExpect() == null : this.getExpect().equals(other.getExpect()))
            && (this.getOpencode1() == null ? other.getOpencode1() == null : this.getOpencode1().equals(other.getOpencode1()))
            && (this.getOpencode2() == null ? other.getOpencode2() == null : this.getOpencode2().equals(other.getOpencode2()))
            && (this.getOpencode3() == null ? other.getOpencode3() == null : this.getOpencode3().equals(other.getOpencode3()))
            && (this.getOpencode4() == null ? other.getOpencode4() == null : this.getOpencode4().equals(other.getOpencode4()))
            && (this.getOpencode5() == null ? other.getOpencode5() == null : this.getOpencode5().equals(other.getOpencode5()))
            && (this.getOpentime() == null ? other.getOpentime() == null : this.getOpentime().equals(other.getOpentime()))
            && (this.getOpentimestamp() == null ? other.getOpentimestamp() == null : this.getOpentimestamp().equals(other.getOpentimestamp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExpect() == null) ? 0 : getExpect().hashCode());
        result = prime * result + ((getOpencode1() == null) ? 0 : getOpencode1().hashCode());
        result = prime * result + ((getOpencode2() == null) ? 0 : getOpencode2().hashCode());
        result = prime * result + ((getOpencode3() == null) ? 0 : getOpencode3().hashCode());
        result = prime * result + ((getOpencode4() == null) ? 0 : getOpencode4().hashCode());
        result = prime * result + ((getOpencode5() == null) ? 0 : getOpencode5().hashCode());
        result = prime * result + ((getOpentime() == null) ? 0 : getOpentime().hashCode());
        result = prime * result + ((getOpentimestamp() == null) ? 0 : getOpentimestamp().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", expect=").append(expect);
        sb.append(", opencode1=").append(opencode1);
        sb.append(", opencode2=").append(opencode2);
        sb.append(", opencode3=").append(opencode3);
        sb.append(", opencode4=").append(opencode4);
        sb.append(", opencode5=").append(opencode5);
        sb.append(", opentime=").append(opentime);
        sb.append(", opentimestamp=").append(opentimestamp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}