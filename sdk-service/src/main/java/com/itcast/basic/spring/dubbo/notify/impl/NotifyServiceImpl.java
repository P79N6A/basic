package com.itcast.basic.spring.dubbo.notify.impl;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.itcast.basic.spring.dubbo.notify.service.NotifyService;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class NotifyServiceImpl implements NotifyService {
    @Override
    public String notify(long time) throws Exception {
        if (time > 1000) {
            throw new Exception("time is too long");
        }
        try {
            System.out.println("enter into NotifyServiceImpl");
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println("NotifyServiceImpl error message is " + e);
        }
        return "success";
    }
}
