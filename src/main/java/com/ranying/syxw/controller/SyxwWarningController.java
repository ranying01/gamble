package com.ranying.syxw.controller;

import com.ranying.cqssc.service.SyxwWarningService;
import com.ranying.cqssc.service.WarningService;
import com.ranying.cqssc.vo.WarningRow;
import com.ranying.syxw.query.SyxwParamQuery;
import com.ranying.syxw.vo.SyxwWarningRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 11选5
 */
@Controller
@RequestMapping("syxw/warning")
public class SyxwWarningController {

    @Autowired
    private SyxwWarningService syxwWarningService;

    @RequestMapping(value = "index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("syxw/syxw_warning");
        return mv;
    }

    @PostMapping(value = "data")
    @ResponseBody
    public List<SyxwWarningRow> listWarning(SyxwParamQuery query) {
        return syxwWarningService.listWarning(query);
    }

}
