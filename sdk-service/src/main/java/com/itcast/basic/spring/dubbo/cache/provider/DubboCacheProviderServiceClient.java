package com.itcast.basic.spring.dubbo.cache.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboCacheProviderServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboCacheProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/cache/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboCacheProviderServiceClient error message is " + e);
        }
    }
}
