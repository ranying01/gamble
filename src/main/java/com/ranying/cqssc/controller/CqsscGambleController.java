package com.ranying.cqssc.controller;

import com.ranying.cqssc.constant.LotteryConstant;
import com.ranying.cqssc.entity.LotteryParam;
import com.ranying.cqssc.service.SyncDataService;
import com.ranying.util.Result;
import com.ranying.cqssc.vo.GenerateResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cqssc")
public class CqsscGambleController {

    @Autowired
    private SyncDataService syncDataService;

    @RequestMapping(value = {"","index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cqssc/index");
        return mv;
    }

    /**
     * 保存参数
     */
    @PostMapping(value = "save")
    @ResponseBody
    public Result save(LotteryParam lotteryParam) {
        try {
            syncDataService.save(lotteryParam);
        } catch (Exception e) {
            return new Result(LotteryConstant.FAIL_CODE, e.getMessage());
        }
        return Result.SUCCESS;
    }

    @PostMapping(value = "generate")
    @ResponseBody
    public GenerateResultVO generate(LotteryParam lotteryParam) {
        GenerateResultVO resultVO = new GenerateResultVO();
        resultVO.setGenerateRows(syncDataService.generate(lotteryParam));
        return resultVO;
    }


}
