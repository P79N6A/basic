package com.itcast.basic.spring.aop.throwadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class SpringThrowAdviceServiceClient {

    private static final Log logger = LogFactory.getLog(SpringThrowAdviceServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringThrowAdviceServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/aop/throwadvice/application.xml"});
            DeleteService deleteService = (DeleteService) applicationContext.getBean("throwAdviceProxy");
            deleteService.delete();
        } catch (Exception e) {
            logger.info("SpringThrowAdviceServiceClient error message is {}", e);
        }
    }
}
