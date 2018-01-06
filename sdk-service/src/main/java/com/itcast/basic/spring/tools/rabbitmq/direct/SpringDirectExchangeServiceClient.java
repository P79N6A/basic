package com.itcast.basic.spring.tools.rabbitmq.direct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/16.
 */
public class SpringDirectExchangeServiceClient {

    private static final Log logger = LogFactory.getLog(SpringDirectExchangeServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringFanoutExchangeServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/tools/rabbitmq/direct/application.xml"});
            AmqpTemplate amqpTemplate = (AmqpTemplate) applicationContext.getBean("amqpTemplate0");
            amqpTemplate.convertAndSend("same.route", "hello world");
        } catch (Exception e) {
            logger.info("error is {}", e);
        }
    }

}
