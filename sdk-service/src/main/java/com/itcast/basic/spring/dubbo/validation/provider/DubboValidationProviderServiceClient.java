package com.itcast.basic.spring.dubbo.validation.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class DubboValidationProviderServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboValidationProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/validation/provider/application.xml"});

            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboValidationProviderServiceClient error is " + e);
        }
    }
}
