package com.itcast.basic.spring.dubbo.injvm.impl;

import com.itcast.basic.spring.dubbo.injvm.service.InjvmService;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class RemoteInjvmServiceImpl implements InjvmService {

    @Override
    public String callback(String invoker) {
        System.out.println("remote invoke" + invoker);
        return "remote";
    }

//    @Override
//    public String injvm(InjvmCallback injvmCallback) {
//        System.out.println("enter into InjvmServiceImpl");
//        if (injvmCallback != null) {
//            System.out.println("injvmCallback invoke");
//            injvmCallback.callback();
//        }
//        return "success";
//    }
}
