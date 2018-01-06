package com.itcast.basic.spring.dubbo.generic;

import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/23.
 */
public class DubboGenerServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboGenerServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/generic/consumer.xml"});
            GenericService generService = (GenericService) applicationContext.getBean("generService");
            String res = (String) generService.$invoke("increaseNumber", new String[]{"java.lang.String"}, new Object[]{"lucy"});
            System.out.println("res=" + res);
        } catch (Exception e) {
            System.out.println("DubboGenerServiceClient error message is" + e);
        }
    }
}
