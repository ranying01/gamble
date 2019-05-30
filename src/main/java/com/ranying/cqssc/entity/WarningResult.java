package com.ranying.cqssc.entity;

import java.io.Serializable;

/**
 * warning_result
 *
 * @author
 */
public class WarningResult implements Serializable {

    private Integer id;

    /**
     * lottery_param 的 id
     */
    private Integer paramId;

    /**
     * lottery_param 的 name
     */
    private String paramName;

    /**
     * lottery_param  的 numbers
     */
    private String paramNumbers;

    /**
     * 参数的格式
     */
    private Integer paramAmount;

    private String currentExpect;

    private String lastExpect;

    /**
     * 位置
     */
    private String location;

    /**
     * 预警后多少期开奖
     */
    private Integer resultPeriod;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamNumbers() {
        return paramNumbers;
    }

    public void setParamNumbers(String paramNumbers) {
        this.paramNumbers = paramNumbers;
    }

    public Integer getParamAmount() {
        return paramAmount;
    }

    public void setParamAmount(Integer paramAmount) {
        this.paramAmount = paramAmount;
    }

    public String getCurrentExpect() {
        return currentExpect;
    }

    public void setCurrentExpect(String currentExpect) {
        this.currentExpect = currentExpect;
    }

    public String getLastExpect() {
        return lastExpect;
    }

    public void setLastExpect(String lastExpect) {
        this.lastExpect = lastExpect;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getResultPeriod() {
        return resultPeriod;
    }

    public void setResultPeriod(Integer resultPeriod) {
        this.resultPeriod = resultPeriod;
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
        WarningResult other = (WarningResult) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getParamId() == null ? other.getParamId() == null : this.getParamId().equals(other.getParamId()))
                && (this.getParamName() == null ? other.getParamName() == null : this.getParamName().equals(other.getParamName()))
                && (this.getParamNumbers() == null ? other.getParamNumbers() == null : this.getParamNumbers().equals(other.getParamNumbers()))
                && (this.getParamAmount() == null ? other.getParamAmount() == null : this.getParamAmount().equals(other.getParamAmount()))
                && (this.getCurrentExpect() == null ? other.getCurrentExpect() == null : this.getCurrentExpect().equals(other.getCurrentExpect()))
                && (this.getLastExpect() == null ? other.getLastExpect() == null : this.getLastExpect().equals(other.getLastExpect()))
                && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
                && (this.getResultPeriod() == null ? other.getResultPeriod() == null : this.getResultPeriod().equals(other.getResultPeriod()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParamId() == null) ? 0 : getParamId().hashCode());
        result = prime * result + ((getParamName() == null) ? 0 : getParamName().hashCode());
        result = prime * result + ((getParamNumbers() == null) ? 0 : getParamNumbers().hashCode());
        result = prime * result + ((getParamAmount() == null) ? 0 : getParamAmount().hashCode());
        result = prime * result + ((getCurrentExpect() == null) ? 0 : getCurrentExpect().hashCode());
        result = prime * result + ((getLastExpect() == null) ? 0 : getLastExpect().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getResultPeriod() == null) ? 0 : getResultPeriod().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", paramId=").append(paramId);
        sb.append(", paramName=").append(paramName);
        sb.append(", paramNumbers=").append(paramNumbers);
        sb.append(", paramAmount=").append(paramAmount);
        sb.append(", currentExpect=").append(currentExpect);
        sb.append(", lastExpect=").append(lastExpect);
        sb.append(", location=").append(location);
        sb.append(", resultPeriod=").append(resultPeriod);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}