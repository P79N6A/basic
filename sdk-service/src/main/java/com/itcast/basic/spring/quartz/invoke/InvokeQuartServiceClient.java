package com.itcast.basic.spring.quartz.invoke;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/25.
 */
public class InvokeQuartServiceClient {

    private static final Log logger = LogFactory.getLog(InvokeQuartServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into InvokeQuartServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/quartz/invoke/application.xml"});
            synchronized (logger) {
                logger.wait();
            }
        } catch (Exception e) {
            logger.info("InvokeQuartServiceClient error message is {}", e);
        }
    }

}
