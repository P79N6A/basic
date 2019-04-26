package com.itcast.basic.spring.dubbo.configdetail.client;

import com.itcast.basic.spring.dubbo.configdetail.service.SaveService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/13.
 */
public class DubboServiceConsumerClient {
//    private final static Log logger = LogFactory.getLog(DubboServiceConsumerClient.class);

    public static void main(String[] args) {
        try {
            System.out.println("enter into DubboServiceConsumerClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo/client/application.xml"});
            SaveService saveService = (SaveService) applicationContext.getBean("saveService");
            saveService.sysHello();
        } catch (Exception e) {
//            logger.info("error message is {}", e);
            System.out.println("error message is {}" + e);
        }
    }
}
