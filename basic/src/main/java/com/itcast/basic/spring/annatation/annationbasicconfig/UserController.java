package com.itcast.basic.spring.annatation.annationbasicconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by qfl on 16/7/31.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void login(User user) {
        System.out.println("用户" + user.getName() + "登录");
        userService.save(user);
    }
}
