package com.itcast.basic.spring.tools.rabbitmq.priorityqueue;

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
public class SpringPriorityQueueServiceClient {

    private static final Log logger = LogFactory.getLog(SpringPriorityQueueServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringFanoutExchangeServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/tools/rabbitmq/priorityqueue/application.xml"});
            AmqpTemplate proAmqpTemplate = (AmqpTemplate) applicationContext.getBean("priorityAmqpTemplate");
            for (int i = 0; i < 10; i++) {
                final int priority = i;
                //优先级队列
                proAmqpTemplate.convertAndSend("priority.message.process", (Object) new StringBuilder("hello world i am lily").append(i).toString(), new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        message.getMessageProperties().setPriority(priority);
                        return message;
                    }
                });
            }

        } catch (Exception e) {
            logger.info("error is {}", e);
        }
    }

}
