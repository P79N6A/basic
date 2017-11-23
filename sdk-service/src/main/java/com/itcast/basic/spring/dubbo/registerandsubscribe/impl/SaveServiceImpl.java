package com.itcast.basic.spring.dubbo.registerandsubscribe.impl;

import com.itcast.basic.spring.dubbo.registerandsubscribe.service.SaveService;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class SaveServiceImpl implements SaveService {

    @Override
    public void save() {
        System.out.println(" registerandsubscribe SaveServiceImpl");
    }
}
