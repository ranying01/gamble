package com.ranying.cqssc.service;

import com.ranying.cqssc.entity.LotteryParam;
import com.ranying.cqssc.vo.GenerateResultVO;
import com.ranying.cqssc.vo.GenerateRow;

import java.util.Date;
import java.util.List;

public interface SyncDataService {

    /**
     *  同步重庆时时彩数据
     */
   void sync();

   void sync(Date date);

    void save(LotteryParam generateParamVO);


    /**
     * 生成一组参数的预警
     * @param lotteryParam  参数（包括参数列表、每一个位置的最大历史遗漏）
     * @return GenerateResultVO
     */
    List<GenerateRow> generate(LotteryParam lotteryParam);

    List<GenerateRow> generate(LotteryParam lotteryParam,Integer warningFlag);

    /**
     * 分析
     * @param id
     * @return
     */
    GenerateResultVO analyze(Integer id);
}
