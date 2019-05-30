package com.ranying.syxw.controller;

import com.ranying.cqssc.constant.LotteryConstant;
import com.ranying.syxw.constant.SyxwConstant;
import com.ranying.syxw.entity.SyxwLotteryParam;
import com.ranying.syxw.service.SyxwLotteryParamService;
import com.ranying.syxw.service.SyxwSyncDataService;
import com.ranying.syxw.vo.SyxwGenerateResultVO;
import com.ranying.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  11选5 Controller
 */
@Controller
@RequestMapping("/syxw")
public class SyxwController {

    @Autowired
    private SyxwLotteryParamService syxwLotteryParamService;

    @Autowired
    private SyxwSyncDataService syxwSyncDataService;

    @RequestMapping(value = {"","index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("syxw/syxw_index");
        return mv;
    }

    /**
     * 保存参数
     */
    @PostMapping(value = "save")
    @ResponseBody
    public Result save(SyxwLotteryParam lotteryParam) {
        try {
            syxwLotteryParamService.save(lotteryParam);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(LotteryConstant.FAIL_CODE, e.getMessage());
        }
        return Result.SUCCESS;
    }

    @PostMapping(value = "save_all")
    @ResponseBody
    public Result saveAll(SyxwLotteryParam lotteryParam) {
        try {
            syxwLotteryParamService.saveAll(lotteryParam);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(LotteryConstant.FAIL_CODE, e.getMessage());
        }
        return Result.SUCCESS;
    }

    @PostMapping(value = "generate")
    @ResponseBody
    public SyxwGenerateResultVO generate(SyxwLotteryParam lotteryParam) {
        SyxwGenerateResultVO resultVO = new SyxwGenerateResultVO();
        resultVO.setGenerateRows(syxwSyncDataService.generate(lotteryParam));
        return resultVO;
    }

}
