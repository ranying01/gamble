package com.ranying.syxw.dao;

import com.ranying.syxw.entity.JsSyxwLotteryRecord;

public interface JsSyxwLotteryRecordDAO {
    int deleteByPrimaryKey(String expect);

    int insert(JsSyxwLotteryRecord record);

    int insertSelective(JsSyxwLotteryRecord record);

    JsSyxwLotteryRecord selectByPrimaryKey(String expect);

    int updateByPrimaryKeySelective(JsSyxwLotteryRecord record);

    int updateByPrimaryKey(JsSyxwLotteryRecord record);
}