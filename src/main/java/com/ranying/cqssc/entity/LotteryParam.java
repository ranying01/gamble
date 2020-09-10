package com.ranying.cqssc.entity;

import com.ranying.cqssc.constant.LotteryConstant;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * lottery_param
 * @author 
 */
public class LotteryParam implements Serializable {

    private Integer id;

    private String name;

    private String numbers;

    private Integer amount;

    /**
     * 位置一（万千百）
     */
    private Integer wqb;

    /**
     * 位置二（万千十）
     */
    private Integer wqs;

    /**
     * 位置三（万千个）
     */
    private Integer wqg;

    /**
     * 位置四（万百十）
     */
    private Integer wbs;

    /**
     * 位置五（万百个）
     */
    private Integer wbg;

    /**
     * 位置六（万十个）
     */
    private Integer wsg;

    /**
     * 位置七（千百十）
     */
    private Integer qbs;

    /**
     * 位置八（千百个）
     */
    private Integer qbg;

    /**
     * 位置九（千十个）
     */
    private Integer qsg;

    /**
     * 位置十（百十个）
     */
    private Integer bsg;

    private static final long serialVersionUID = 1L;
    private List<String> numberList;

    public Integer getLocationWarning(LotteryConstant.Arrange location){
        switch (location.getValue()){
            case "wqb": return getWqb();
            case "wqs": return getWqs();
            case "wqg": return getWqg();
            case "wbs": return getWbs();
            case "wbg": return getWbg();
            case "wsg": return getWsg();
            case "qbs": return getQbs();
            case "qbg": return getQbg();
            case "qsg": return getQsg();
            case "bsg": return getBsg();
        }
        return null;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getWqb() {
        return wqb;
    }

    public void setWqb(Integer wqb) {
        this.wqb = wqb;
    }

    public Integer getWqs() {
        return wqs;
    }

    public void setWqs(Integer wqs) {
        this.wqs = wqs;
    }

    public Integer getWqg() {
        return wqg;
    }

    public void setWqg(Integer wqg) {
        this.wqg = wqg;
    }

    public Integer getWbs() {
        return wbs;
    }

    public void setWbs(Integer wbs) {
        this.wbs = wbs;
    }

    public Integer getWbg() {
        return wbg;
    }

    public void setWbg(Integer wbg) {
        this.wbg = wbg;
    }

    public Integer getWsg() {
        return wsg;
    }

    public void setWsg(Integer wsg) {
        this.wsg = wsg;
    }

    public Integer getQbs() {
        return qbs;
    }

    public void setQbs(Integer qbs) {
        this.qbs = qbs;
    }

    public Integer getQbg() {
        return qbg;
    }

    public void setQbg(Integer qbg) {
        this.qbg = qbg;
    }

    public Integer getQsg() {
        return qsg;
    }

    public void setQsg(Integer qsg) {
        this.qsg = qsg;
    }

    public Integer getBsg() {
        return bsg;
    }

    public void setBsg(Integer bsg) {
        this.bsg = bsg;
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
        LotteryParam other = (LotteryParam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getNumbers() == null ? other.getNumbers() == null : this.getNumbers().equals(other.getNumbers()))
                && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
                && (this.getWqb() == null ? other.getWqb() == null : this.getWqb().equals(other.getWqb()))
                && (this.getWqs() == null ? other.getWqs() == null : this.getWqs().equals(other.getWqs()))
                && (this.getWqg() == null ? other.getWqg() == null : this.getWqg().equals(other.getWqg()))
                && (this.getWbs() == null ? other.getWbs() == null : this.getWbs().equals(other.getWbs()))
                && (this.getWbg() == null ? other.getWbg() == null : this.getWbg().equals(other.getWbg()))
                && (this.getWsg() == null ? other.getWsg() == null : this.getWsg().equals(other.getWsg()))
                && (this.getQbs() == null ? other.getQbs() == null : this.getQbs().equals(other.getQbs()))
                && (this.getQbg() == null ? other.getQbg() == null : this.getQbg().equals(other.getQbg()))
                && (this.getQsg() == null ? other.getQsg() == null : this.getQsg().equals(other.getQsg()))
                && (this.getBsg() == null ? other.getBsg() == null : this.getBsg().equals(other.getBsg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNumbers() == null) ? 0 : getNumbers().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getWqb() == null) ? 0 : getWqb().hashCode());
        result = prime * result + ((getWqs() == null) ? 0 : getWqs().hashCode());
        result = prime * result + ((getWqg() == null) ? 0 : getWqg().hashCode());
        result = prime * result + ((getWbs() == null) ? 0 : getWbs().hashCode());
        result = prime * result + ((getWbg() == null) ? 0 : getWbg().hashCode());
        result = prime * result + ((getWsg() == null) ? 0 : getWsg().hashCode());
        result = prime * result + ((getQbs() == null) ? 0 : getQbs().hashCode());
        result = prime * result + ((getQbg() == null) ? 0 : getQbg().hashCode());
        result = prime * result + ((getQsg() == null) ? 0 : getQsg().hashCode());
        result = prime * result + ((getBsg() == null) ? 0 : getBsg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", numbers=").append(numbers);
        sb.append(", amount=").append(amount);
        sb.append(", wqb=").append(wqb);
        sb.append(", wqs=").append(wqs);
        sb.append(", wqg=").append(wqg);
        sb.append(", wbs=").append(wbs);
        sb.append(", wbg=").append(wbg);
        sb.append(", wsg=").append(wsg);
        sb.append(", qbs=").append(qbs);
        sb.append(", qbg=").append(qbg);
        sb.append(", qsg=").append(qsg);
        sb.append(", bsg=").append(bsg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 讲输入的参数列表转换为 List
     *
     * @return List<String>
     */
    public List<String> getNumberList() {

        String numbers = getNumbers();
        if (StringUtils.isBlank(numbers)) {
            throw new RuntimeException("输入格式不正确");
        }
        String[] numberArray = numbers.split("\\s+");
        List<String> queryList = new ArrayList<>();
        for (String subNumberStr : numberArray) {
            System.out.println(subNumberStr);
            char[] singleNumberStr = subNumberStr.toCharArray();
            Integer number1 = (int) singleNumberStr[0] - '0';
            Integer number2 = (int) singleNumberStr[1] - '0';
            Integer number3 = (int) singleNumberStr[2] - '0';
            System.out.println(number1);
            System.out.println(number2);
            System.out.println(number3);
            queryList.add(subNumberStr);
        }
        return queryList;
    }
}