package com.ranying.cqssc.controller;

import com.ranying.cqssc.entity.LotteryParam;
import com.ranying.cqssc.service.ParamService;
import com.ranying.cqssc.service.SyncDataService;
import com.ranying.util.Result;
import com.ranying.cqssc.vo.GenerateResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("cqssc/param")
public class CqsscParamController {

    @Resource
    private ParamService paramService;

    @Resource
    private SyncDataService syncDataService;

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cqssc/param_list");
        return mv;
    }

    @RequestMapping(value = "/data")
    @ResponseBody
    public List<LotteryParam> data() {
        return paramService.list();
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable Integer id) {
        paramService.delete(id);
        return Result.SUCCESS;
    }

    /**
     * 打开参照
     */
    @RequestMapping(value = "{id}/param_analyze")
    public ModelAndView paramAnalyzeIndex(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.setViewName("cqssc/param_analyze");
        return modelAndView;
    }

    @PostMapping(value = "/analyze/{id}")
    @ResponseBody
    public GenerateResultVO analyze(@PathVariable("id") Integer id) {
        return syncDataService.analyze(id);
    }


}
