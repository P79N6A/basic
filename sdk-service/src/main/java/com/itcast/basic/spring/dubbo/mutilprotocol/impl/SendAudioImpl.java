package com.itcast.basic.spring.dubbo.mutilprotocol.impl;

import com.itcast.basic.spring.dubbo.mutilprotocol.service.SendAudio;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class SendAudioImpl implements SendAudio {
    @Override
    public void send() {
        System.out.println("invoke SendAudioImpl");
    }
}
