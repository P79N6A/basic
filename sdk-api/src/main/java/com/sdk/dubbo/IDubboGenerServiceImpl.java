package com.sdk.dubbo;

import com.sdk.service.IDubboGenerService;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class IDubboGenerServiceImpl implements IDubboGenerService {

    public String increaseNumber(String content) {
        System.out.println("request:" + content);
        return "hello world";
    }
}
