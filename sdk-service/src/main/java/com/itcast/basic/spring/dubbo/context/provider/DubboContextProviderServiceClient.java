package com.itcast.basic.spring.dubbo.context.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboContextProviderServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboContextProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/context/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboContextProviderServiceClient error message is" + e);
        }
    }
}
