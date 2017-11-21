package com.itcast.basic.spring.dubbo.directservice.client;

import com.itcast.basic.spring.dubbo.directservice.service.SaveService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class DubboDirectServiceConstumerClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboDirectServiceConstumerClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/directservice/client/application.xml"});
            SaveService remoteService = (SaveService) applicationContext.getBean("remoteService");
            remoteService.sys();
            SaveService localService = (SaveService) applicationContext.getBean("localService");
            localService.sys();
        } catch (Exception e) {
            System.out.println("DubboDirectServiceConstumerClient error is " + e);
        }
    }
}
