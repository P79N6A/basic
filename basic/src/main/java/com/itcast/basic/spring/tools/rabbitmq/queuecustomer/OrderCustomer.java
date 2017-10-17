package com.itcast.basic.spring.tools.rabbitmq.queuecustomer;

import com.rabbitmq.client.Channel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

/**
 * Created by treey.qian on 2017/10/17.
 */
public class OrderCustomer implements ChannelAwareMessageListener {

    private final Log log = LogFactory.getLog(OrderCustomer.class);

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            log.info("receive message is " + new String(message.getBody()));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }
}
