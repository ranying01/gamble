package com.ranying.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户登录
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(value = {"","index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login/index");
        return mv;
    }

}
