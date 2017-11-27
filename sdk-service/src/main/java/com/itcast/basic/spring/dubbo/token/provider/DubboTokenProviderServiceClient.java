package com.itcast.basic.spring.dubbo.token.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboTokenProviderServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboTokenProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/token/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboTokenProviderServiceClient error message is" + e);
        }
    }
}
