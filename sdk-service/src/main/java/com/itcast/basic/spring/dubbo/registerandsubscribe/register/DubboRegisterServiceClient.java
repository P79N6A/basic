package com.itcast.basic.spring.dubbo.registerandsubscribe.register;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class DubboRegisterServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboRegisterServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/registerandsubscribe/register/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboRegisterServiceClient error is " + e);
        }
    }
}