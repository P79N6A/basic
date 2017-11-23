package com.itcast.basic.spring.dubbo.validation.impl;

import com.itcast.basic.spring.dubbo.validation.model.ValidationParameter;
import com.itcast.basic.spring.dubbo.validation.service.ValidationService;

import javax.validation.constraints.NotNull;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class ValidationServiceImpl implements ValidationService {

    @Override
    public void save(@NotNull ValidationParameter parameter) {
        System.out.println("invoke save method");
    }

    @Override
    public void update(@NotNull ValidationParameter parameter) {
        System.out.println("invoke update method");
    }

    @Override
    public void delete(int id) {
        System.out.println("invoke delete method");
    }
}
