package com.itcast.basic.jdk.nio.socketchannel.block;

/**
 * Created by Administrator on 2018/2/10.
 */
public class SocketUtilsMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into SocketUtilsMain");
            SocketUtils.startSocketServer(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
