package com.itcast.basic.spring.dubbo.token.client;

import com.itcast.basic.spring.dubbo.token.service.AuthService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboTokenServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboTokenServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/token/client/application.xml"});
            AuthService authService = (AuthService) applicationContext.getBean("authService");
            System.out.println("result is " + authService.auth());
        } catch (Exception e) {
            System.out.println("DubboTokenServiceClient error message is" + e);
        }
    }
}
