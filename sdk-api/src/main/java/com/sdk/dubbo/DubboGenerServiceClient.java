package com.sdk.dubbo;

import com.sdk.service.IDubboGenerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboGenerServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboGenerServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"dubbo/consumer.xml"});
            IDubboGenerService generService = (IDubboGenerService) applicationContext.getBean("generService");
            String res = generService.increaseNumber("lily");
            System.out.println("res=" + res);
        } catch (Exception e) {
            System.out.println("DubboGenerServiceClient error message is" + e);
        }
    }
}
