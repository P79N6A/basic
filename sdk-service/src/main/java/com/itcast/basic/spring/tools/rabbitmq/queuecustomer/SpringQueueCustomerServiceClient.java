package com.itcast.basic.spring.tools.rabbitmq.queuecustomer;

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
public class SpringQueueCustomerServiceClient {

    private static final Log logger = LogFactory.getLog(SpringQueueCustomerServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringQueueCustomerServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/tools/rabbitmq/queuecustomer/application.xml"});
            AmqpTemplate proAmqpTemplate = (AmqpTemplate) applicationContext.getBean("orderAmqpTemplate");
            for (int i = 0; i < 10; i++) {
                final int priority = i;
                //优先级队列
                proAmqpTemplate.convertAndSend("pro.order.process", (Object) new StringBuilder("hello world i am lily").append(i).toString(), new MessagePostProcessor() {
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
