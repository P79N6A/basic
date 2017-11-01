package com.itcast.basic.controller.freemarker;

import com.itcast.basic.controller.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by treey.qian on 2017/10/31.
 */
@RequestMapping("freemarker")
@Controller
public class FreemarkerController {

    @RequestMapping(value = "/user", method = {RequestMethod.GET})
    public ModelAndView getUserInfo() {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = new UserInfo(2011416842, "Lily", "wuhan");
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("userInfo");
        return modelAndView;
    }
}
