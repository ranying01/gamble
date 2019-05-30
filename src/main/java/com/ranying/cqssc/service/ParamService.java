package com.ranying.cqssc.service;

import com.ranying.cqssc.entity.LotteryParam;

import java.util.List;

public interface ParamService {

    List<LotteryParam> list();

    void delete(Integer id);
}
