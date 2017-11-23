package com.itcast.basic.spring.dubbo.mutilprotocol.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class DubboMutilProtocolProviderServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboMutilProtocolProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/mutilprotocol/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboMutilProtocolProviderServiceClient error is" + e);
        }
    }
}
