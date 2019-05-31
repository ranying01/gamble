package com.ranying.syxw.controller;

import com.ranying.syxw.entity.SyxwLotteryParam;
import com.ranying.syxw.query.SyxwParamQuery;
import com.ranying.syxw.service.SyxwLotteryParamService;
import com.ranying.syxw.vo.SyxwGenerateResultVO;
import com.ranying.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/syxw/param")
public class SyxwParamController {

    @Autowired
    private SyxwLotteryParamService syxwLotteryParamService;

    @RequestMapping(value = {"","index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("syxw/syxw_param_list");
        return mv;
    }

    @RequestMapping(value = "/data")
    @ResponseBody
    public List<SyxwLotteryParam> data(SyxwParamQuery syxwParamQuery) {
        List<SyxwLotteryParam>  list = syxwLotteryParamService.list(syxwParamQuery);
        return list;
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable Integer id) {
        syxwLotteryParamService.delete(id);
        return Result.SUCCESS;
    }

    /**
     * 打开分析参照
     */
    @RequestMapping(value = "{id}/param_analyze")
    public ModelAndView paramAnalyzeIndex(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.setViewName("syxw/syxw_param_analyze");
        return modelAndView;
    }

    @GetMapping(value = "{id}/edit")
    public ModelAndView editPage(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.addObject("entity",syxwLotteryParamService.getEntity(id));
        modelAndView.setViewName("syxw/syxw_param_edit");
        return modelAndView;
    }

    @PostMapping(value = "{id}/edit")
    @ResponseBody
    public Result saveEdit(@PathVariable("id") Integer id,SyxwLotteryParam syxwLotteryParam) {
        syxwLotteryParam.setId(id);
        syxwLotteryParamService.update(syxwLotteryParam);
        return Result.SUCCESS;

    }

    @PostMapping(value = "/analyze/{id}")
    @ResponseBody
    public SyxwGenerateResultVO analyze(@PathVariable("id") Integer id) {
        return syxwLotteryParamService.analyze(id);
    }

}
