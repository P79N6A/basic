package com.itcast.basic.spring.aop.afteradvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class SpringAfterAdviceServiceClient {
    private static final Log logger = LogFactory.getLog(SpringAfterAdviceServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringAfterAdviceServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/aop/afteradvice/application.xml"});
            UpdateService updateService = (UpdateService) applicationContext.getBean("afterAdviceProxy");
            updateService.update();
        } catch (Exception e) {
            logger.info("SpringAfterAdviceServiceClient error message is {}", e);
        }
    }
}
