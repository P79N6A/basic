package com.itcast.basic.spring.tools.rabbitmq.fanout;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/16.
 */
public class SpringFanoutExchangeServiceClient {

    private static final Log logger = LogFactory.getLog(SpringFanoutExchangeServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringFanoutExchangeServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/tools/rabbitmq/fanout/application.xml"});
            AmqpTemplate amqpTemplate = (AmqpTemplate) applicationContext.getBean("amqpTemplate");
            amqpTemplate.convertAndSend("hello world");
        } catch (Exception e) {
            logger.info("error is {}", e);
        }
    }

}
