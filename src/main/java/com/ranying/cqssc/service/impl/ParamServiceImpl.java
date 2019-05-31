package com.ranying.cqssc.service.impl;

import com.ranying.cqssc.service.ParamService;
import com.ranying.cqssc.dao.LotteryParamDAO;
import com.ranying.cqssc.entity.LotteryParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParamServiceImpl implements ParamService {

    @Resource
    private LotteryParamDAO lotteryParamDAO;

    @Override
    public List<LotteryParam> list() {
        return lotteryParamDAO.findAll();
    }

    @Override
    public void delete(Integer id) {
        lotteryParamDAO.deleteByPrimaryKey(id);
    }
}
