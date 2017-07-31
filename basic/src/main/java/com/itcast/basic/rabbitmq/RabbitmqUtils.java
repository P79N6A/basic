package com.itcast.basic.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by treey.qian on 2017/7/24.
 */
public class RabbitmqUtils {

    private String defaultHost = "127.0.0.1";

    private String defaultUserName = "admin";

    private String defaultPassword = "123456";

    private int defaultPort = 5672;

    private Channel channel = null;

    private Connection connection = null;

    public RabbitmqUtils() {

    }

    public RabbitmqUtils(String defaultHost, String defaultUserName, String defaultPassword, int defaultPort) {
        this.defaultHost = defaultHost;
        this.defaultUserName = defaultUserName;
        this.defaultPassword = defaultPassword;
        this.defaultPort = defaultPort;
    }

    public Channel getChannel() {

        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost(defaultHost);
            connectionFactory.setUsername(defaultUserName);
            connectionFactory.setPassword(defaultPassword);
            connectionFactory.setPort(defaultPort);
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return channel;
    }

    public void closeClient() {
        try {
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "RabbitmqUtils{" +
                "defaultHost='" + defaultHost + '\'' +
                ", defaultUserName='" + defaultUserName + '\'' +
                ", defaultPassword='" + defaultPassword + '\'' +
                ", defaultPort=" + defaultPort +
                '}';
    }
}




















