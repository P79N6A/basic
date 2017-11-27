package com.itcast.basic.spring.dubbo.mock.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboMockProviderServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboMockProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/mock/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboMockProviderServiceClient error message is" + e);
        }
    }
}
