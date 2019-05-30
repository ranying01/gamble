package com.ranying.util;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public final static  Result SUCCESS = new Result(200,"成功");

    public static  Result FAIL = new Result(200,null);

    public Result() {
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result getSUCCESS() {
        return SUCCESS;
    }

    public static Result getFAIL() {
        return FAIL;
    }

    public static void setFAIL(Result FAIL) {
        Result.FAIL = FAIL;
    }
}
