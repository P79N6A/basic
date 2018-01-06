package com.itcast.basic.spring.aop.instroductionadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class SpringInstroductionAdviceServiceClient {
    private static final Log logger = LogFactory.getLog(SpringInstroductionAdviceServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringInstroductionAdviceServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/aop/instroductionadvice/application.xml"});
            MessageService messageService = (MessageService) applicationContext.getBean("adviceProxy");
            messageService.sendEmailMessage();
            logger.info("***********************************************");
            messageService.sendPhoneMessage();

        } catch (Exception e) {
            logger.info("SpringInstroductionAdviceServiceClient error message is {} ", e);
        }
    }
}
