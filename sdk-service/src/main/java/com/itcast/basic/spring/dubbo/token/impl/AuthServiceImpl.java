package com.itcast.basic.spring.dubbo.token.impl;


import com.itcast.basic.spring.dubbo.token.service.AuthService;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class AuthServiceImpl implements AuthService {


    @Override
    public String auth() {
        System.out.println("AuthServiceImpl invoke auth...");
        return "success";
    }
}
