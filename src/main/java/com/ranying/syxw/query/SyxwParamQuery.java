package com.ranying.syxw.query;

import java.io.Serializable;

public class SyxwParamQuery implements Serializable {

    private Integer id;

    private String type;

    private String name;

    private String numbers;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SyxwParamQuery getCopy(){
        SyxwParamQuery query = new SyxwParamQuery();
        query.setType(this.type);
        query.setName(this.name);
        query.setNumbers(this.numbers);
        query.setId(this.id);
        return query;
    }

}
