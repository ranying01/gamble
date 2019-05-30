package com.ranying.cqssc.dao;

import com.ranying.cqssc.entity.LotteryParam;
import com.ranying.cqssc.query.LotteryParamQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LotteryParamDAO {

    int deleteByPrimaryKey(Integer id);

    int insert(LotteryParam record);

    int insertSelective(LotteryParam record);

    LotteryParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LotteryParam record);

    int updateByPrimaryKey(LotteryParam record);

    List<LotteryParam> findAll();

    List<LotteryParam> listByQuery(LotteryParamQuery query);

}