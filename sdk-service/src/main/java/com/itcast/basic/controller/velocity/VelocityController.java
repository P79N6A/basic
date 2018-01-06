package com.itcast.basic.controller.velocity;

import com.itcast.basic.controller.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by treey.qian on 2017/10/31.
 */
@RequestMapping("velocity")
@Controller
public class VelocityController {

    @RequestMapping(value = "/user", method = {RequestMethod.GET})
    public String getUserInfo(Model model) {
        UserInfo userInfo = new UserInfo(2011416842, "Lily", "wuhan");
        model.addAttribute("user", userInfo);
        return "userInfo";
    }
}
