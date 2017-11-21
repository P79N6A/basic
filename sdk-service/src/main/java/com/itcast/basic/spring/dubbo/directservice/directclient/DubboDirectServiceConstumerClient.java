package com.itcast.basic.spring.dubbo.directservice.directclient;

import com.itcast.basic.spring.dubbo.directservice.service.SaveService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/21.
 */
public class DubboDirectServiceConstumerClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into directclient DubboDirectServiceConstumerClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/directservice/directclient/application.xml"});
            SaveService directService = (SaveService) applicationContext.getBean("directService");
            directService.sys();
        } catch (Exception e) {
            System.out.println("DubboDirectServiceConstumerClient error is " + e);
        }
    }
}
