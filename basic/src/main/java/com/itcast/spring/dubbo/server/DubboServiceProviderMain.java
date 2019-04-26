package com.itcast.spring.dubbo.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * Created by treey.qian on 2017/11/13.
 */
public class DubboServiceProviderMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboServiceProviderMain");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/provider/application.xml"});
            CountDownLatch countDownLatch = new CountDownLatch(1);
            countDownLatch.await();
        } catch (Exception e) {
            System.out.println("error message is {}" + e);
        }
    }
}
