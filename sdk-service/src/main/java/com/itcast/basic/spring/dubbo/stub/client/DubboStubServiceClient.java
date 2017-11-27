package com.itcast.basic.spring.dubbo.stub.client;

import com.itcast.basic.spring.dubbo.stub.service.SaveService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboStubServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboStubServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/stub/client/application.xml"});
            SaveService saveService = (SaveService) applicationContext.getBean("saveService");
            saveService.save();
        } catch (Exception e) {
            System.out.println("DubboStubServiceClient error message is" + e);
        }
    }
}
