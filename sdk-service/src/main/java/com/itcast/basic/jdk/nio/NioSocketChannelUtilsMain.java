package com.itcast.basic.jdk.nio;

import com.itcast.basic.jdk.nio.socketchannel.NIOSocketChannelUtils;

/**
 * Created by treey.qian on 2018/2/7.
 */
public class NioSocketChannelUtilsMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into NioSocketChannelUtilsMain");
//            SocketChannelBlockUtils.startSocketChannel(2000);
            NIOSocketChannelUtils.startNIOServerSocket(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
