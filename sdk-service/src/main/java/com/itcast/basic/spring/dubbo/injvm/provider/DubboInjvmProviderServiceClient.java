package com.itcast.basic.spring.dubbo.injvm.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboInjvmProviderServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboInjvmProviderServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/injvm/provider/application.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("DubboInjvmProviderServiceClient error message is" + e);
        }
    }
}
