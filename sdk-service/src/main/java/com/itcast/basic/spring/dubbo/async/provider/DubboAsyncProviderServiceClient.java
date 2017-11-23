package com.itcast.basic.spring.dubbo.async.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboAsyncProviderServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboAsyncProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/async/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboAsyncProviderServiceClient error message is" + e);
        }
    }
}
