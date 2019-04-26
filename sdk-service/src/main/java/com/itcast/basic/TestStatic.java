package com.itcast.basic;

import com.itcast.basic.test.Object1;
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
            System.out.println("enter into TestStatic ");
//            FileInputStream fileInputStream = new FileInputStream("e:\\ClassFileObject.class");
//            int i = -1;
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            while ((i = fileInputStream.read()) != -1) {
//                byteArrayOutputStream.write(i);
//            }
//            byte[] bytes = byteArrayOutputStream.toByteArray();
//            System.out.println("size of bytes is " + bytes.length);
//            String className = ClassFileObject.class.getName();
//            SimpleLoader simpleLoader = new SimpleLoader(bytes, className);
//            Class classType = simpleLoader.loadClass(className);
//            ClassFileObject classFileObject = (ClassFileObject) classType.newInstance();
//            System.out.println("classType= " + classType + " classFileObject=" + classFileObject);
//            ClassFileObject o = (ClassFileObject) classType.newInstance();
//            System.out.print("simpleLoader=" + simpleLoader + " " + o.id);

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
//            Class classes = Class.forName(ClassFileObject.class.getName());
//            System.out.print("classes=" + classes);
//            Class class0 = ClassFileObject.class;
//            System.out.print("class0=" + class0);
//            String dir = System.getProperty("java.ext.dirs");
//            System.out.println("dir=" + dir);
//            String[] dirs = dir.split(";");
//            for (String d : dirs) {
//                System.out.println(d);
//            }
//            String dir0 = System.getProperty("java.class.path");
//            System.out.println("dir0=" + dir0);
//            dirs = dir0.split(";");
//            for (String d : dirs) {
//                System.out.println(d);
//            }
            Object1 object1 = new Object1();
            object1.sysHello();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SimpleLoader extends ClassLoader {

        private byte[] bytes;
        private String className;

        public SimpleLoader(byte[] bytes, String className) {
            this.bytes = bytes;
            this.className = className;
        }

        @Override
        public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            return super.loadClass(name, resolve);
        }

        @Override
        public Class<?> findClass(String name) throws ClassNotFoundException {
            return defineClass(className, bytes, 0, bytes.length);
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

