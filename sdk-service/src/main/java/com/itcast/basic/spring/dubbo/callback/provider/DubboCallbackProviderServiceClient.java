package com.itcast.basic.spring.dubbo.callback.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboCallbackProviderServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboCallbackProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/callback/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboCallbackProviderServiceClient error message is" + e);
        }
    }
}
