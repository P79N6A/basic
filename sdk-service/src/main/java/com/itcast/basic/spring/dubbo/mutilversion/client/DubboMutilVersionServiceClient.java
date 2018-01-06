package com.itcast.basic.spring.dubbo.mutilversion.client;

import com.itcast.basic.spring.dubbo.mutilversion.service.FeedbackService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class DubboMutilVersionServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboMutilVersionServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/mutilversion/client/application.xml"});
            FeedbackService beifuFeedbackService=(FeedbackService)applicationContext.getBean("beifuFeedbackService");
            beifuFeedbackService.callback();
            FeedbackService ebaFeedbackService=(FeedbackService)applicationContext.getBean("ebaFeedbackService");
            ebaFeedbackService.callback();
        } catch (Exception e) {
            System.out.println("DubboMutilVersionServiceClient error is " + e);
        }
    }
}
