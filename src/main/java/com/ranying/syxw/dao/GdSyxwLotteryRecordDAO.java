package com.ranying.syxw.dao;

import com.ranying.syxw.entity.GdSyxwLotteryRecord;
import com.ranying.syxw.query.SyxwLotteryRecordQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GdSyxwLotteryRecordDAO {

    int deleteByPrimaryKey(String expect);

    int insert(GdSyxwLotteryRecord record);

    int insertSelective(GdSyxwLotteryRecord record);

    GdSyxwLotteryRecord selectByPrimaryKey(String expect);

    int updateByPrimaryKeySelective(GdSyxwLotteryRecord record);

    int updateByPrimaryKey(GdSyxwLotteryRecord record);

    //int countPeriod(String expect);
}