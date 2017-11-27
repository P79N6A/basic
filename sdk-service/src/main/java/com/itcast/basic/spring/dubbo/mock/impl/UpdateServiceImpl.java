package com.itcast.basic.spring.dubbo.mock.impl;


import com.itcast.basic.spring.dubbo.mock.service.UpdateService;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class UpdateServiceImpl implements UpdateService {

    @Override
    public String update() {
        try {
            System.out.println("UpdateServiceImpl invoke update");
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("UpdateServiceImpl error is" + e);
        }
        return "success";
    }
}
