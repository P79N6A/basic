package com.sdk.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboGenerServiceProviderClient {

    public static void main(String[] args){
        try {
            System.out.println("enter into DubboGenerServiceProviderClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"dubbo/provider.xml"});
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        }catch (Exception e){
            System.out.println("DubboGenerServiceProviderClient error message is"+e);
        }
    }
}
