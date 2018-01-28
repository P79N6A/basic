package com.itcast.basic.sockettype.socket.server;

import java.io.*;
import java.net.Socket;

/**
 * Created by qfl on 16/4/28.
 */
public class ServerBean extends Thread {

    private Socket socket;

    public ServerBean(Socket socket) {
        this.socket = socket;
    }


    public void writeData(String text) {
        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            System.out.println("text is " + text);
            pw.write(text + "\n");
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        listen();
    }

    private void listen() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            String content = "";
            while ((content = br.readLine()) != null) {
                System.out.println("服务端收到的信息为:" + content);
                ServerBeanUtils.sendAll(this, content);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
