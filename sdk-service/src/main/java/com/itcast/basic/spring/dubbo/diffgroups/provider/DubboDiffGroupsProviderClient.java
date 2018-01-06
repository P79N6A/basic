package com.itcast.basic.spring.dubbo.diffgroups.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class DubboDiffGroupsProviderClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboDiffGroupsProviderClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/diffgroups/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboDiffGroupsProviderClient error is " + e);
        }
    }
}
