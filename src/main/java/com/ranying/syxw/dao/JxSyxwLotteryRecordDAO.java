package com.ranying.syxw.dao;

import com.ranying.syxw.entity.JxSyxwLotteryRecord;

public interface JxSyxwLotteryRecordDAO {
    int deleteByPrimaryKey(String expect);

    int insert(JxSyxwLotteryRecord record);

    int insertSelective(JxSyxwLotteryRecord record);

    JxSyxwLotteryRecord selectByPrimaryKey(String expect);

    int updateByPrimaryKeySelective(JxSyxwLotteryRecord record);

    int updateByPrimaryKey(JxSyxwLotteryRecord record);
}