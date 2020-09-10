package com.ranying.syxw.entity;

import com.ranying.syxw.constant.SyxwConstant;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * syxw_lottery_param
 *
 * @author
 */
public class SyxwLotteryParam implements Serializable {
    private Integer id;

    /**
     * 广东11选5、 山西11选5 、上海11选5
     */
    private String type;

    private String typeName;

    /**
     * 参数名称
     */
    private String name;

    /**
     * 参数列表
     */
    private String numbers;

    /**
     * 参数个数
     */
    private Integer amount;

    /**
     * 历史最大遗漏
     */
    private Integer maxNeglect;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getTypeName() {
        return SyxwConstant.SYXW_TYPE_MAP.get(type).getName();
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setType(String type) {
        this.type = type;
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

    public Integer getMaxNeglect() {
        return maxNeglect;
    }

    public void setMaxNeglect(Integer maxNeglect) {
        this.maxNeglect = maxNeglect;
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
        SyxwLotteryParam other = (SyxwLotteryParam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getNumbers() == null ? other.getNumbers() == null : this.getNumbers().equals(other.getNumbers()))
                && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
                && (this.getMaxNeglect() == null ? other.getMaxNeglect() == null : this.getMaxNeglect().equals(other.getMaxNeglect()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNumbers() == null) ? 0 : getNumbers().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getMaxNeglect() == null) ? 0 : getMaxNeglect().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", numbers=").append(numbers);
        sb.append(", amount=").append(amount);
        sb.append(", maxNeglect=").append(maxNeglect);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 讲输入的参数列表转换为 List
     *
     * @return List<String>
     */
    public List<String[]> getNumberList() {
        String numbers = getNumbers();
        if (StringUtils.isBlank(numbers)) {
            throw new RuntimeException("输入格式不正确");
        }
        String[] numberArray = numbers.split(",");
        Arrays.sort(numberArray);
        List<String[]> queryList = new ArrayList<>();
        for (String subNumberStr : numberArray) {
            String[] group = subNumberStr.split("\\s+");
            queryList.add(group);
        }
        return queryList;
    }

    public List<String> getCodes() {
        String numbers = getNumbers();
        if (StringUtils.isBlank(numbers)) {
            throw new RuntimeException("输入格式不正确");
        }
        String[] numberArray = numbers.split(",");
        List<String> queryList = new ArrayList<>();
        for (String subNumberStr : numberArray) {
            String[] group = subNumberStr.split("\\s+");
            Arrays.sort(group);
            StringBuilder groupStr = new StringBuilder();
            for (String g : group) {
                groupStr.append(g + ",");
            }
            queryList.add(groupStr.toString().substring(0, groupStr.length() - 1));
        }
        return queryList;
    }

}