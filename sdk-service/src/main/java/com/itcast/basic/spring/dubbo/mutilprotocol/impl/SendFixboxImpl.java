package com.itcast.basic.spring.dubbo.mutilprotocol.impl;

import com.itcast.basic.spring.dubbo.mutilprotocol.service.SendFixbox;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class SendFixboxImpl implements SendFixbox {
    @Override
    public void send() {
        System.out.println("invoke SendFixboxImpl");
    }
}
