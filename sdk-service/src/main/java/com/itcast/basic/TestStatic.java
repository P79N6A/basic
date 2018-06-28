package com.itcast.basic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by treey.qian on 2018/3/27.
 */
public class TestStatic {
    public final static String QUEUE_NAME = "MonirQueue";
    public final static String EXCHANGE_NAME = "";

    public static void main(String[] args) {
        try {
            //创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置RabbitMQ相关信息
            factory.setHost("10.108.29.240");
            factory.setUsername("admin");
            factory.setPassword("admin");
            factory.setPort(5672);
            factory.setVirtualHost("/");
            factory.setConnectionTimeout(20000);
            //创建一个新的连接
            Connection connection = factory.newConnection();
            //创建一个通道
            Channel channel = connection.createChannel();
            //
            Map<String, Object> arguments = new HashedMap();
            arguments.put("", "");
            arguments.put("", "");
            //  声明一个队列
            channel.queueDeclare(QUEUE_NAME, true, false, false, arguments);
            String message = "Hello RabbitMQ";
            //发送消息到队列中
            channel.basicPublish(EXCHANGE_NAME, QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println("Producer Send +'" + message + "'");
            //关闭通道和连接
            channel.close();
            connection.close();
//            block:{
//                System.out.println("enter into block");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Pserson {
        private String name;

        public Pserson(Pserson pserson) {
            this.name = pserson.name;
        }
    }

    class Human {
        private String name;

        public Human(Human human) {
            this.name = human.name;
        }
    }
}

