package com.itcast.basic.test.qfl.rabbitmq;

import com.rabbitmq.client.*;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import java.util.Map;

/**
 * Created by treey.qian on 2018/6/27.
 */
public class TestMQ {

    @Test
    public void testCreate() {
        try {
            String EXCHANGE_NAME = "";
            String QUEUE_NAME = "MonirQueue0";
            //创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置RabbitMQ相关信息
            factory.setHost("10.108.29.240");
            factory.setUsername("admin");
            factory.setPassword("a123456");
            factory.setPort(5673);
            factory.setVirtualHost("/");
            factory.setConnectionTimeout(20000);
            //创建一个新的连接
            Connection connection = factory.newConnection();
            //创建一个通道
            Channel channel = connection.createChannel();
            //rabbitmqctl set_policy --priority 0 --apply-to queues mirror_queue "MonirQueue" '{"ha-mode":"all"}'
            // rabbitmqctl  set_policy  queue-ha  "MonirQueue"  '{"ha-mode":"all"}'
            Map<String, Object> arguments = new HashedMap();
            arguments.put("ha-model", "all");
//            arguments.put("", "");
            //  声明一个队列
            channel.queueDeclare(QUEUE_NAME, true, false, false, arguments);
            String message = "Hello RabbitMQ";
            //发送消息到队列中
            AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
            builder.deliveryMode(2);
            AMQP.BasicProperties properties = builder.build();
            channel.basicPublish(EXCHANGE_NAME, QUEUE_NAME, properties, message.getBytes("UTF-8"));
            System.out.println("Producer Send +'" + message + "'");
            //关闭通道和连接
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPop() {
        try {
            String QUEUE_NAME = "MonirQueue";
            //创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置RabbitMQ相关信息
            factory.setHost("10.108.29.240");
            factory.setUsername("admin");
            factory.setPassword("admin");
            factory.setPort(5673);
            factory.setVirtualHost("/");
            factory.setConnectionTimeout(20000);
            //创建一个新的连接
            Connection connection = factory.newConnection();
            //创建一个通道
            Channel channel = connection.createChannel();
            //发送消息到队列中
            GetResponse response = channel.basicGet(QUEUE_NAME, true);
            //
            String receiveMessage = new String(response.getBody());
            System.out.println("receiveMessage=" + receiveMessage);
            //关闭通道和连接
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
