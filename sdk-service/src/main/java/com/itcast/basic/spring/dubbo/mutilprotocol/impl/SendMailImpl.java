package com.itcast.basic.spring.dubbo.mutilprotocol.impl;

import com.itcast.basic.spring.dubbo.mutilprotocol.service.SendMail;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class SendMailImpl implements SendMail {
    @Override
    public void send() {
        System.out.println("invoke SendMailImpl");
    }
}
