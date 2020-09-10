package com.ranying.cqssc.query;

import java.io.Serializable;

public class LotteryParamQuery implements Serializable {

    private String name;

    private String numbers;

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
}
