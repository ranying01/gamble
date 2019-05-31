package com.ranying.cqssc.dao;

import com.ranying.cqssc.entity.LotteryRecord;
import com.ranying.cqssc.vo.GenerateVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LotteryRecordDAO {

    int deleteByPrimaryKey(String expect);

    int insert(LotteryRecord record);

    int insertSelective(LotteryRecord record);

    LotteryRecord selectByPrimaryKey(String expect);

    int updateByPrimaryKeySelective(LotteryRecord record);

    int updateByPrimaryKey(LotteryRecord record);

    /**
     * 获取数据库最近的一期
     *
     * @return LotteryRecord
     */
    LotteryRecord selectLatestPeriod();

    /**
     * 批量插入
     *
     * @param records 记录
     * @return 插入记录数
     */
    int batchInsert(@Param("records") List<LotteryRecord> records);


    List<GenerateVO> queryGenerate(@Param("queryList") List<String> queryList,@Param("location") String location);

    List<GenerateVO>  queryWaringResult(@Param("queryList") List<String> queryList,@Param("location") String location,@Param("currentExpect") String currentExpect );

    int countPeriod(@Param("latestExpect") String latestExpect);

    List<LotteryRecord> list(LotteryRecord lotteryRecord);

    int countBetweenPeriod(@Param("beginExpect") String beginExpect, @Param("endExpect")  String endExpect);
}