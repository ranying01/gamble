package com.ranying.syxw.dao;

import com.ranying.syxw.entity.SdSyxwLotteryRecord;

public interface SdSyxwLotteryRecordDAO {
    int deleteByPrimaryKey(String expect);

    int insert(SdSyxwLotteryRecord record);

    int insertSelective(SdSyxwLotteryRecord record);

    SdSyxwLotteryRecord selectByPrimaryKey(String expect);

    int updateByPrimaryKeySelective(SdSyxwLotteryRecord record);

    int updateByPrimaryKey(SdSyxwLotteryRecord record);
}