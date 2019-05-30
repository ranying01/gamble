package com.ranying.cqssc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author WangMin
 * @version V1.0
 * @since 2019/3/13
 */
public class PstnPhoneCallRecordDTO implements Serializable {

    /**
     * 通话时长
     */
    private Integer duration;

    /**
     * 备注
     */
    private String remark;

    /**
     * 开始通话时间
     */
    private String startTime;

    /**
     * 结束通话时间
     */
    private String endTime;

    /**
     * A号码
     */
    private String phoneNo;

    /**
     * B号码
     */
    private String peerPhoneNo;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPeerPhoneNo() {
        return peerPhoneNo;
    }

    public void setPeerPhoneNo(String peerPhoneNo) {
        this.peerPhoneNo = peerPhoneNo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
