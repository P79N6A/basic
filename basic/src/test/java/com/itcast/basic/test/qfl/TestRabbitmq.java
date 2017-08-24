package com.itcast.basic.test.qfl;

import com.itcast.basic.rabbitmq.RabbitmqUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by treey.qian on 2017/7/24.
 */
public class TestRabbitmq {

    public final static String QUEUE_NAME = "queue-test";

    //延迟队列
    @Test
    public void testCreate() {
        try {
            RabbitmqUtils rabbitmqUtils = new RabbitmqUtils();
            Channel channel = rabbitmqUtils.getChannel();
            channel.exchangeDeclare("exchange.beifu.payment", "direct");
            Map<String, Object> args = new HashMap<String, Object>();
            args.put("x-message-ttl", 10000);
            args.put("x-dead-letter-exchange", "exchange.beifu.payment");
            args.put("x-dead-letter-routing-key", "payment");
            AMQP.Queue.DeclareOk declareOk = channel.queueDeclare(QUEUE_NAME, false, false, false, args);
            System.out.println("declareOk=" + declareOk);
            channel.basicPublish("", QUEUE_NAME, null, "hello world".getBytes("utf-8"));
            rabbitmqUtils.closeClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCustomer() {
        try {
            RabbitmqUtils rabbitmqUtils = new RabbitmqUtils();
            Channel channel = rabbitmqUtils.getChannel();
            // 每次从队列中获取数量（负载均衡）
            channel.basicQos(1);
            //创建消费者对象，用于读取消息
            QueueingConsumer consumer = new QueueingConsumer(channel);
            //创建一个消费者
            /**
             * arg0 队列名字
             * arg1 是否自动应答，如果为真，消息一旦被消费者收到，服务端就知道该消息已经投递，从而从队列中将消息剔除，
             * 否则，需要在消费者端手工调用channel.basicAck()方法通知服务端，
             * 如果没有调用，消息将会进入unacknowledged状态，并且当消费者连接断开后变成ready状态重新进入队列
             * arg2 具体消费者类
             */
            channel.basicConsume(QUEUE_NAME, true, consumer);
            //读取队列，并且阻塞，即在读到消息之前在这里阻塞，直到等到消息，完成消息的阅读后，继续阻塞循环
            while (true) {
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());
                AMQP.BasicProperties props = delivery.getProperties();
                System.out.println(" [x] Received '" + message + "'" + "message id is " + props.getMessageId());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testService() {
        try {
            System.out.println("hello world!");
            System.err.println("error occur");
            String dir = System.getProperty("user.dir");
            System.out.println("dir=" + dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}





























