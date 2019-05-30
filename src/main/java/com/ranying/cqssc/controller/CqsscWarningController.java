package com.ranying.cqssc.controller;

import com.ranying.cqssc.service.SyxwWarningService;
import com.ranying.cqssc.service.WarningService;
import com.ranying.cqssc.vo.WarningRow;
import com.ranying.syxw.query.SyxwParamQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("cqssc/warning")
public class CqsscWarningController {

    @Autowired
    private WarningService warningService;

    @RequestMapping(value = "index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cqssc/warning");
        return mv;
    }

    @PostMapping(value = "data")
    @ResponseBody
    public List<WarningRow> listWarning() {
        return warningService.listWarning();
    }

}
