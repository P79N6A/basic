package com.itcast.basic.spring.tools.rabbitmq.headers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/16.
 */
public class SpringHeadersExchangeServiceClient {

    private static final Log logger = LogFactory.getLog(SpringHeadersExchangeServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringFanoutExchangeServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/tools/rabbitmq/headers/application.xml"});
            AmqpTemplate amqpTemplate = (AmqpTemplate) applicationContext.getBean("amqpTemplate2");
            MessageProperties messageProperties = new MessageProperties();
            //这里x-match有两种类型
            //all:表示所有的键值对都匹配才能接受到消息
            //any:表示只要有键值对匹配就能接受到消息
            messageProperties.setHeader("name", "personQueue2");
            Message message = new Message("header".getBytes(), messageProperties);
            amqpTemplate.send(message);
        } catch (Exception e) {
            logger.info("error is {}", e);
        }
    }

}
