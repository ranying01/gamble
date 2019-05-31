package com.ranying.syxw.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * gdsyxw_lottery_record
 * @author 
 */
public class GdSyxwLotteryRecord extends SyxwLotteryBaseRecord implements Serializable {

    private static final long serialVersionUID = 1L;

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
        GdSyxwLotteryRecord other = (GdSyxwLotteryRecord) that;
        return (this.getExpect() == null ? other.getExpect() == null : this.getExpect().equals(other.getExpect()))
            && (this.getOpencode1() == null ? other.getOpencode1() == null : this.getOpencode1().equals(other.getOpencode1()))
            && (this.getOpencode2() == null ? other.getOpencode2() == null : this.getOpencode2().equals(other.getOpencode2()))
            && (this.getOpencode3() == null ? other.getOpencode3() == null : this.getOpencode3().equals(other.getOpencode3()))
            && (this.getOpencode4() == null ? other.getOpencode4() == null : this.getOpencode4().equals(other.getOpencode4()))
            && (this.getOpencode5() == null ? other.getOpencode5() == null : this.getOpencode5().equals(other.getOpencode5()))
            && (this.getOpentime() == null ? other.getOpentime() == null : this.getOpentime().equals(other.getOpentime()))
            && (this.getOpentimestamp() == null ? other.getOpentimestamp() == null : this.getOpentimestamp().equals(other.getOpentimestamp()))
            && (this.getWarningStatisticFlag() == null ? other.getWarningStatisticFlag() == null : this.getWarningStatisticFlag().equals(other.getWarningStatisticFlag()));
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
        result = prime * result + ((getWarningStatisticFlag() == null) ? 0 : getWarningStatisticFlag().hashCode());
        return result;
    }


}