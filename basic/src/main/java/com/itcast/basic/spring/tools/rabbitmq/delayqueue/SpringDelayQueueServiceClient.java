package com.itcast.basic.spring.tools.rabbitmq.delayqueue;

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
public class SpringDelayQueueServiceClient {

    private static final Log logger = LogFactory.getLog(SpringDelayQueueServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringFanoutExchangeServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/tools/rabbitmq/delayqueue/application.xml"});
            AmqpTemplate proAmqpTemplate = (AmqpTemplate) applicationContext.getBean("delayAmqpTemplate");
            //延迟队列
            proAmqpTemplate.convertAndSend("delay.message.process", (Object) "hello world", new MessagePostProcessor() {
                @Override
                public Message postProcessMessage(Message message) throws AmqpException {
//                    message.getMessageProperties().setExpiration("5000");
                    return message;
                }
            });
        } catch (Exception e) {
            logger.info("error is {}", e);
        }
    }

}
