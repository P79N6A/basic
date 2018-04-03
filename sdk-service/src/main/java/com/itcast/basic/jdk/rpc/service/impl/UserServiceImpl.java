package com.itcast.basic.jdk.rpc.service.impl;

import com.itcast.basic.jdk.rpc.service.UserService;

/**
 * Created by treey.qian on 2018/4/3.
 */
public class UserServiceImpl implements UserService {

    @Override
    public Object select() {
        System.out.println("select user ");
        return "success";
    }
}
