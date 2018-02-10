package com.itcast.basic.jdk.net;

import com.itcast.basic.jdk.net.socket.SocketUtils;

/**
 * Created by treey.qian on 2018/2/8.
 */
public class SockMain {

    public static void main(String[] args) {
        try {
          System.out.println("enter into SockMain");
            SocketUtils.startServerSocket(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
