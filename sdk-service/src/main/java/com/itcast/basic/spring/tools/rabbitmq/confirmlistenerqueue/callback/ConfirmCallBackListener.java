package com.itcast.basic.spring.tools.rabbitmq.confirmlistenerqueue.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;

public class ConfirmCallBackListener implements ConfirmCallback {

    private final Logger logger = LoggerFactory.getLogger(ConfirmCallBackListener.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        try {
            logger.info("ack is" + ack);
        } catch (Exception e) {
            logger.info("confirm error message is", e);
        }
    }
}