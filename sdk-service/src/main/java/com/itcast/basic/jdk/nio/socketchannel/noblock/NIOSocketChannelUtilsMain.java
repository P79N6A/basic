package com.itcast.basic.jdk.nio.socketchannel.noblock;

/**
 * Created by Administrator on 2018/2/10.
 */
public class NIOSocketChannelUtilsMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into NIOSocketChannelUtilsMain");
            NIOSocketChannelUtils.startNIOServerSocket(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
