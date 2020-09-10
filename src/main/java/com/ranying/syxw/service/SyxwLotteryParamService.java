package com.ranying.syxw.service;

import com.github.pagehelper.PageInfo;
import com.ranying.common.PageParam;
import com.ranying.syxw.entity.SyxwLotteryParam;
import com.ranying.syxw.query.SyxwParamQuery;
import com.ranying.syxw.vo.SyxwGenerateResultVO;

import java.util.List;

public interface SyxwLotteryParamService {

    void save(SyxwLotteryParam lotteryParam);

    void delete(Integer id);

    List<SyxwLotteryParam> list(SyxwParamQuery syxwParamQuery);

    SyxwGenerateResultVO analyze(Integer id);

    SyxwLotteryParam getEntity(Integer id);

    void update(SyxwLotteryParam syxwLotteryParam);

    void saveAll(SyxwLotteryParam lotteryParam);

    PageInfo<SyxwLotteryParam> list(SyxwParamQuery syxwParamQuery, PageParam pageParam);
}
