package com.itcast.basic.jdk.nio.socketchannel.noblock;

/**
 * Created by Administrator on 2018/2/10.
 */
public class NIOSocketChannelUtilsClientMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into NIOSocketChannelUtilsClientMain");
            NIOSocketChannelUtils.startNIOSocketClient("127.0.0.1", 2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
