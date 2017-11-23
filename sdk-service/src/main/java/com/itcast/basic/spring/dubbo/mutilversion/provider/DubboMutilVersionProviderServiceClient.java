package com.itcast.basic.spring.dubbo.mutilversion.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class DubboMutilVersionProviderServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboMutilVersionProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/mutilversion/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboMutilVersionProviderServiceClient error is " + e);
        }
    }
}
