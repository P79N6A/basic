package com.itcast.basic.spring.rmi.spring.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/30.
 */
public class RmiSpringServiceClient {

    private static final Log logger = LogFactory.getLog(RmiSpringServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into RmiSpringServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/rmi/spring/server/application.xml"});

            synchronized (logger) {
                logger.wait();
            }
        } catch (Exception e) {
            logger.info("RmiSpringServiceClient error message is {}", e);
        }
    }
}
