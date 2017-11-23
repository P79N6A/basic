package com.itcast.basic.spring.dubbo.async.impl;

import com.itcast.basic.spring.dubbo.async.service.AsyncService;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class AsyncServiceImpl implements AsyncService {
    @Override
    public String async() {
        try {
            Thread.sleep(1000);
            System.out.println("AsyncServiceImpl async invoke");
        } catch (Exception e) {
            System.out.println("error message is " + e);
        }
        return "success";
    }
}
