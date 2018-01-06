package com.itcast.basic.spring.dubbo.registerandsubscribe.impl;

import com.itcast.basic.spring.dubbo.registerandsubscribe.service.UpdateService;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class UpdateServiceImpl implements UpdateService {

    @Override
    public void update() {
        System.out.println(" registerandsubscribe UpdateServiceImpl");
    }

}
