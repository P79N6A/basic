package com.itcast.basic.spring.dubbo.injvm.impl;

import com.itcast.basic.spring.dubbo.injvm.service.InjvmService;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class LocalInjvmServiceImpl implements InjvmService {
    @Override
    public String callback(String invoker) {
        System.out.println("local invoke" + invoker);
        return "local";
    }
}
