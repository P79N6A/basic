package com.itcast.basic.spring.dubbo.mutilversion.impl;

import com.itcast.basic.spring.dubbo.mutilversion.service.FeedbackService;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class BeifuFeedbackServiceImpl implements FeedbackService {
    @Override
    public void callback() {
        System.out.println("BeifuFeedbackServiceImpl invoke");
    }
}
