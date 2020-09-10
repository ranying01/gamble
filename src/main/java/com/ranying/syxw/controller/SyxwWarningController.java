package com.ranying.syxw.controller;

import com.ranying.cqssc.service.SyxwWarningService;
import com.ranying.syxw.constant.SyxwConstant;
import com.ranying.syxw.query.SyxwParamQuery;
import com.ranying.syxw.vo.SyxwWarningRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
    public List<SyxwWarningRow> listWarning(SyxwParamQuery query) throws InterruptedException {
        List<SyxwWarningRow> result = new ArrayList<>();

        Boolean[] flags = {false, false, false, false, false};

        class Query implements Runnable {

            private SyxwParamQuery nQuery;

            public Query(SyxwParamQuery nQuery) {
                this.nQuery = nQuery;
            }

            @Override
            public void run() {
                List<SyxwWarningRow> gdRow = syxwWarningService.listWarning(nQuery);
                result.addAll(gdRow);
                switch (nQuery.getType()) {
                    case "gd11x5":
                        flags[0] = true;
                        break;
                    case "jx11x5":
                        flags[1] = true;
                        break;
                    case "sh11x5":
                        flags[2] = true;
                        break;
                    case "sd11x5":
                        flags[3] = true;
                        break;
                    case "js11x5":
                        flags[4] = true;
                        break;
                }
            }
        }

        if ("-1".equals(query.getType())) {

            SyxwParamQuery q1 = query.getCopy();
            q1.setType(SyxwConstant.LotteryType.GD.getValue());
            Thread t1 = new Thread(new Query(q1));
            t1.start();

            SyxwParamQuery q2 = query.getCopy();
            q2.setType(SyxwConstant.LotteryType.JX.getValue());
            Thread t2 = new Thread(new Query(q2));
            t2.start();

            SyxwParamQuery q3 = query.getCopy();
            q3.setType(SyxwConstant.LotteryType.SH.getValue());
            Thread t3 = new Thread(new Query(q3));
            t3.start();

            SyxwParamQuery q4 = query.getCopy();
            q4.setType(SyxwConstant.LotteryType.SD.getValue());
            Thread t4 = new Thread(new Query(q4));
            t4.start();

            SyxwParamQuery q5 = query.getCopy();
            q5.setType(SyxwConstant.LotteryType.JS.getValue());
            Thread t5 = new Thread(new Query(q5));
            t5.start();

            while (true) {
                int i = 0;
                for (; i < flags.length; i++) {
                    if (flags[i].equals(false)) {
                        Thread.sleep(1000);
                        break;
                    }
                }
                if (i == flags.length) {
                    break;
                }
            }
        } else {
            return syxwWarningService.listWarning(query);
        }
        return result;
    }

}
