package com.ranying.syxw.query;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class SyxwLotteryRecordQuery implements Serializable {

    private String table;

    private Integer expect;

    // private String[] lotteryNumbers;

    private List<String[]> lotteryNumbers;

    private List<String> codesList;

    private Integer limit;

    private Date begin;

    private Date end;

}
