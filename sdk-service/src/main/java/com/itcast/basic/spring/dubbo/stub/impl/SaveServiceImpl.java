package com.itcast.basic.spring.dubbo.stub.impl;

import com.itcast.basic.spring.dubbo.stub.service.SaveService;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class SaveServiceImpl implements SaveService {
    @Override
    public void save() {
        try {
            System.out.println("SaveServiceImpl invoke save data");
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("SaveServiceImpl error message is " + e);
        }

    }
}
