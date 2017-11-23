package com.itcast.basic.spring.dubbo.echoservice.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboEchoProviderServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboEchoProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/echoservice/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboEchoProviderServiceClient error message is" + e);
        }
    }
}
