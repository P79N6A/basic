package com.itcast.basic.spring.dubbo.mutilprotocol.impl;

import com.itcast.basic.spring.dubbo.mutilprotocol.service.SendMessage;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class SendMessageImpl implements SendMessage {
    @Override
    public void send() {
        System.out.println("invoke SendMessageImpl");
    }
}
