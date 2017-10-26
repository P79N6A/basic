package com.itcast.basic.spring.quartz.simple;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/25.
 */
public class SimpleQuartzServiceClient {
    private static final Log logger = LogFactory.getLog(SimpleQuartzServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SimpleQuartzServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/quartz/simple/application.xml"});
            synchronized (logger) {
                logger.wait();
            }
        } catch (Exception e) {
            logger.info("SimpleQuartzServiceClienterror messag is {}", e);
        }
    }
}
