package com.ranying.syxw.dao;

import com.ranying.syxw.entity.ShSyxwLotteryRecord;

public interface ShSyxwLotteryRecordDAO {
    int deleteByPrimaryKey(String expect);

    int insert(ShSyxwLotteryRecord record);

    int insertSelective(ShSyxwLotteryRecord record);

    ShSyxwLotteryRecord selectByPrimaryKey(String expect);

    int updateByPrimaryKeySelective(ShSyxwLotteryRecord record);

    int updateByPrimaryKey(ShSyxwLotteryRecord record);
}