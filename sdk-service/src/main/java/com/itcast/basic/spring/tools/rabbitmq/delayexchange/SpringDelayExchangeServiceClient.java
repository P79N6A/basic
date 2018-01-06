package com.itcast.basic.spring.tools.rabbitmq.delayexchange;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/16.
 */
public class SpringDelayExchangeServiceClient {

    private static final Log logger = LogFactory.getLog(SpringDelayExchangeServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringFanoutExchangeServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/tools/rabbitmq/delayexchange/application.xml"});
            AmqpTemplate proAmqpTemplate = (AmqpTemplate) applicationContext.getBean("delayAmqpTemplate");
            //延迟队列
            proAmqpTemplate.convertAndSend("delay.message.process", (Object) "hello world", new MessagePostProcessor() {
                @Override
                public Message postProcessMessage(Message message) throws AmqpException {
                    message.getMessageProperties().setDelay(15000);
                    return message;
                }
            });
        } catch (Exception e) {
            logger.info("error is {}", e);
        }
    }

}
