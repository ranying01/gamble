package com.ranying.cqssc.query;

import com.ranying.common.PageParam;

import java.io.Serializable;

/**
 * 查询预警后结果条件
 */
public class WarningResultQuery extends PageParam implements Serializable {

    private String location;

    private String paramName;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

}
