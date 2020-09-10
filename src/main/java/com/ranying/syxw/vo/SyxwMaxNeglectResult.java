package com.ranying.syxw.vo;

import java.io.Serializable;

public class SyxwMaxNeglectResult implements Serializable{

    private Integer maxNeglect;

    private String expect;

    private String preExpect;

    public Integer getMaxNeglect() {
        return maxNeglect;
    }

    public void setMaxNeglect(Integer maxNeglect) {
        this.maxNeglect = maxNeglect;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getPreExpect() {
        return preExpect;
    }

    public void setPreExpect(String preExpect) {
        this.preExpect = preExpect;
    }
}
