package com.itcast.basic.spring.tools.rabbitmq.confirmlistenerqueue.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;


public class ReturnCallBackListener implements ReturnCallback {

    private final Logger logger = LoggerFactory.getLogger(ReturnCallBackListener.class);

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        try {
            logger.info("消息路由(routingKey=" + routingKey + ")不正确，消息(message=" + message + ")发送失败");
        } catch (Exception e) {
            logger.info("returnedMessage error message is", e);
        }
    }
}