package com.itcast.basic.spring.dubbo.stub.impl;

import com.itcast.basic.spring.dubbo.stub.service.SaveService;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class SaveServiceStub implements SaveService {

    private SaveService saveService;

    public SaveServiceStub(SaveService saveService) {
        this.saveService = saveService;
    }

    @Override
    public void save() {
        System.out.println("SaveServiceStub invoke check data");
        saveService.save();
        System.out.println("SaveServiceStub invoke commit data");
    }
}
