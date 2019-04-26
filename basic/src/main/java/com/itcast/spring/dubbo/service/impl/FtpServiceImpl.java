package com.itcast.spring.dubbo.service.impl;

import com.itcast.spring.dubbo.service.FtpService;

/**
 * Created by treey.qian on 2018/4/10.
 */
public class FtpServiceImpl implements FtpService {
    @Override
    public void open() {
        System.out.println("enter into FtpServiceImpl");
    }
}
