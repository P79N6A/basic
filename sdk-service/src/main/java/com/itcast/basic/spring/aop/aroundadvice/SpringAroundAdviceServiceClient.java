package com.itcast.basic.spring.aop.aroundadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class SpringAroundAdviceServiceClient {
    private static final Log logger = LogFactory.getLog(SpringAroundAdviceServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringAroundAdviceServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/aop/aroundadvice/application.xml"});
            FindService findService = (FindService) applicationContext.getBean("aroundAdviceProxy");
            findService.find();
        } catch (Exception e) {
            logger.info("SpringAroundAdviceServiceClient error message is {}", e);
        }
    }
}
