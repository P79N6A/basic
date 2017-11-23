package com.itcast.basic.spring.dubbo.cache.impl;

import com.itcast.basic.spring.dubbo.cache.service.IncreaseService;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class NumberIncreaseServiceImpl implements IncreaseService {

    private final AtomicInteger i = new AtomicInteger();

    @Override
    public String increase(String id) {
        StringBuilder stringBuilder = new StringBuilder("request:")
                .append(id)
                .append(" ")
                .append("response:")
                .append(i.getAndIncrement())
                .append(" currentTime:")
                .append(System.currentTimeMillis());
        return stringBuilder.toString();
    }
}
