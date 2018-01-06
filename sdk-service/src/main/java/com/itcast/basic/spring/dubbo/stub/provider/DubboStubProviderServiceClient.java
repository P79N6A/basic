package com.itcast.basic.spring.dubbo.stub.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboStubProviderServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboStubProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/stub/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboStubProviderServiceClient error message is" + e);
        }
    }
}
