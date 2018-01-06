package com.itcast.basic.spring.dubbo.directservice.provider;

import com.itcast.basic.spring.dubbo.directservice.service.SaveService;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class PersonSave implements SaveService {

    @Override
    public void sys() {
        System.out.println("invoke provider personSave");
    }
}
