package com.itcast.basic.spring.dubbo.directservice.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class DubboDirectServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboDirectServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/directservice/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboDirectServiceClient error is" + e);
        }
    }
}
