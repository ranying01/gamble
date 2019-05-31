package com.ranying.syxw.dao;

import com.ranying.syxw.entity.SyxwLotteryParam;
import com.ranying.syxw.query.SyxwParamQuery;

import java.util.List;

public interface SyxwLotteryParamDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(SyxwLotteryParam record);

    int insertSelective(SyxwLotteryParam record);

    SyxwLotteryParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SyxwLotteryParam record);

    int updateByPrimaryKey(SyxwLotteryParam record);

    List<SyxwLotteryParam> listByQuery(SyxwParamQuery query);

}