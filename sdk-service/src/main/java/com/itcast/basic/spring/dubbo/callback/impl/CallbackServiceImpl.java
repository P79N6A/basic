package com.itcast.basic.spring.dubbo.callback.impl;

import com.itcast.basic.spring.dubbo.callback.service.Callback;
import com.itcast.basic.spring.dubbo.callback.service.CallbackService;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class CallbackServiceImpl implements CallbackService {
    @Override
    public String invoke(Callback callback) {
        System.out.println("enter into CallbackServiceImpl");
        if (callback != null) {
            callback.callback();
        }
        return "success";
    }
}
