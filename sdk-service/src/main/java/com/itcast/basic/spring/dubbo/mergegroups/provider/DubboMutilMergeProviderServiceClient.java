package com.itcast.basic.spring.dubbo.mergegroups.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class DubboMutilMergeProviderServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboMutilMergeServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/mergegroups/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboMutilMergeServiceClient error is " + e);
        }
    }
}
