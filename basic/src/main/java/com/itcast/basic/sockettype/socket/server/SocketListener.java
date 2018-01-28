package com.itcast.basic.sockettype.socket.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by qfl on 16/4/28.
 */
public class SocketListener extends Thread {
    private int port;

    public SocketListener(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            System.out.println("服务已开启....");
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                ServerBean serverBean = new ServerBean(socket);
                serverBean.start();
                ServerBeanUtils.addElement(serverBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
