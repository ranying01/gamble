package com.ranying.cqssc.controller;

import com.github.pagehelper.PageInfo;
import com.ranying.cqssc.entity.WarningResult;
import com.ranying.cqssc.query.WarningResultQuery;
import com.ranying.cqssc.service.WarningResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("cqssc/warning/result")
public class CqsscWarningResultsController {

    @Autowired
    private WarningResultsService warningResultsService;

    @RequestMapping(value = {"", "index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cqssc/result");
        return mv;
    }

    /**
     * 获取预警数据（分页）
     */
    @RequestMapping(value = "data")
    @ResponseBody
    public PageInfo<WarningResult> listWarning(WarningResultQuery query) {
        return warningResultsService.listResult(query);
    }

}
