package com.itcast.basic.sockettype.socket.simpledemo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by qfl on 16/4/28.
 */
public class SocketDemoClass {
    public static void main(String[] args) {
        final String host = "127.0.0.1";
        final int port = 2000;
        new Thread(new Runnable() {
            @Override
            public void run() {
                SocketDemo.firstStartServer(port);
            }
        }).start();

        for (int i = 0; i < 3; i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("connection");
                    SocketDemo.connectionServer("127.0.0.1", 2000);
                }
            }).start();
    }
}

class SocketDemo {

    public static void firstStartServer(int port) {

        try {
            System.out.println("服务端口已经开启");
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                final Socket socket = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("收到客户端的链接请求");
                            InputStream inputStream = socket.getInputStream();
                            int i = 0;
                            byte[] buffer = new byte[1024];
                            while ((i = inputStream.read(buffer)) != -1) {
                                System.out.println("从客户端接受的信息为:" + new String(buffer));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }).start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void secondStartServer(int port) {

        try {
            System.out.println("服务端口已经开启");
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("收到客户端的链接请求");
                InputStream inputStream = socket.getInputStream();
                int i = 0;
                byte[] buffer = new byte[1024];
                while ((i = inputStream.read(buffer)) != -1) {
                    System.out.println("从客户端接受的信息为:" + new String(buffer));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void connectionServer(String host, int port) {

        try {
            Socket socket = new Socket(host, port);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write((Thread.currentThread().getName() + "send message is " + "hello world").getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
