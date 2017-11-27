package com.itcast.basic.spring.dubbo.mock.client;

import com.itcast.basic.spring.dubbo.mock.service.UpdateService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboMockServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboMockServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/mock/client/application.xml"});
            UpdateService updateService = (UpdateService) applicationContext.getBean("updateService");
            System.out.println("result is " + updateService.update());
        } catch (Exception e) {
            System.out.println("DubboMockServiceClient error message is" + e);
        }
    }
}
