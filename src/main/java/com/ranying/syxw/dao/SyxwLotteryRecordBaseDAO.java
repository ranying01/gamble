package com.ranying.syxw.dao;

import com.ranying.syxw.entity.GdSyxwLotteryRecord;
import com.ranying.syxw.entity.SyxwLotteryBaseRecord;
import com.ranying.syxw.query.SyxwLotteryRecordQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SyxwLotteryRecordBaseDAO {

    List<SyxwLotteryBaseRecord> list(SyxwLotteryRecordQuery syxwLotteryQuery);

    int batchInsert(@Param("table")String table,@Param("records") List<SyxwLotteryBaseRecord> records);

    int deleteByPrimaryKey(String expect);

    int insert(GdSyxwLotteryRecord record);

    int insertSelective(GdSyxwLotteryRecord record);

    GdSyxwLotteryRecord selectByPrimaryKey(String expect);

    int updateByPrimaryKeySelective(GdSyxwLotteryRecord record);

    int updateByPrimaryKey(GdSyxwLotteryRecord record);

    //List<GdSyxwLotteryRecord> list(SyxwLotteryRecordQuery syxwLotteryQuery);

    String searchMaxExpect(@Param("table") String table);

    int countPeriod(@Param("table") String table,@Param("expect") String expect);

    int searchPeriod(@Param("table") String table,@Param("expect") String expect,@Param("preExpect") String preExpect);

}
