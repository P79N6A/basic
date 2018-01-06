package com.itcast.basic.spring.dubbo.notify.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboNotifyProviderServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboNotifyProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/notify/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboNotifyProviderServiceClient error message is" + e);
        }
    }
}
