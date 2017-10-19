package com.itcast.basic.spring.aop.beforeadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class SpringBeforeAdviceServiceClient {

    private static final Log logger = LogFactory.getLog(SpringBeforeAdviceServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringBeforeAdviceServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/aop/beforeadvice/application.xml"});
            SaveService saveService = (SaveService) applicationContext.getBean("beforeAdviceProxy");
            saveService.save();
        } catch (Exception e) {
            logger.info("SpringBeforeAdviceServiceClient error message is {}", e);
        }
    }
}
