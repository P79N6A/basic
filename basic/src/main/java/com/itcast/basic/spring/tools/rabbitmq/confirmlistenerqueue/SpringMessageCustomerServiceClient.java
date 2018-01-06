package com.itcast.basic.spring.tools.rabbitmq.confirmlistenerqueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/16.
 */
public class SpringMessageCustomerServiceClient {

    private static final Log logger = LogFactory.getLog(SpringMessageCustomerServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringMessageCustomerServiceClient");
            new ClassPathXmlApplicationContext(new String[]{"spring/tools/rabbitmq/confirmlistenerqueue/application.xml"});
        } catch (Exception e) {
            logger.info("error is {}", e);
        }
    }

}
