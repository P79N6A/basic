package com.itcast.basic.jdk.net.chatroom.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by qfl on 16/4/28.
 */
public class ClientBeanUtils {
    private static final ClientBeanUtils clientBeanUtils = new ClientBeanUtils();
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;
    private ClientBean clientBean;

    public static ClientBeanUtils getInstance() {
        return clientBeanUtils;
    }

    public void setClient(ClientBean clientBean) {
        this.clientBean = clientBean;
    }

    public void connect(final String host, final int port) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket(host, port);
                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    pw = new PrintWriter(socket.getOutputStream());
                    while ((br.readLine()) != null) {
                        System.out.println("客户端收到的信息为:" + br.readLine());
                        clientBean.appendTest(br.readLine());
                    }
                    br.close();
                    pw.close();
                    br = null;
                    pw = null;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void send(String text) {

        if (pw != null) {
            try {
                /*
                 *必须添加 "\n"
                 * 必须强制刷新
                 */
                pw.write(text + "\n");
                pw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
