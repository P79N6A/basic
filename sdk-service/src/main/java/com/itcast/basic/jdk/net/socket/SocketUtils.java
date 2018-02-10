package com.itcast.basic.jdk.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by treey.qian on 2018/2/8.
 */
public class SocketUtils {

    /**
     * 开启服务
     *
     * @param port 服务端口号
     * @throws IOException
     */
    public static void startServerSocket(int port) throws IOException {
        System.out.println("服务端口已经开启");
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("收到客户端的链接请求");
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int i = 0;
            while ((i = inputStream.read(bytes)) != -1) {
                System.out.println("text is " + new String(bytes));
            }
            inputStream.close();
            socket.close();
        }
    }

    /**
     * 连接服务
     *
     * @param host 域名
     * @param port 端口
     * @throws IOException
     */
    public static void startClient(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello world ".getBytes());
        outputStream.close();
        socket.close();
    }

    private SocketUtils() {

    }
}
