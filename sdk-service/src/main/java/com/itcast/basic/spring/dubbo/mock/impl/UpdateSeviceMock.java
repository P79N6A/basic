package com.itcast.basic.spring.dubbo.mock.impl;

import com.itcast.basic.spring.dubbo.mock.service.UpdateService;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class UpdateSeviceMock implements UpdateService {

    @Override
    public String update() {
        try {
            System.out.println("enter into UpdateSeviceMock");

        } catch (Exception e) {
            System.out.println("UpdateSeviceMock error message is" + e);
        }
        return "mock success";
    }
}
