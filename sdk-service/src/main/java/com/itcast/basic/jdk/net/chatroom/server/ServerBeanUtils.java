package com.itcast.basic.jdk.net.chatroom.server;

import java.util.Vector;

/**
 * Created by qfl on 16/4/28.
 */
public class ServerBeanUtils extends Thread {

    private static Vector<ServerBean> serverBeens = new Vector<ServerBean>();

    public static void addElement(ServerBean serverBean) {
        if (serverBeens != null)
            serverBeens.add(serverBean);
    }

    public static void sendAll(ServerBean serverBean, String sendText) {
        for (ServerBean newServerBean : serverBeens) {
            if (serverBean != newServerBean) {
                System.out.println("sendText is " + sendText);
                newServerBean.writeData(sendText);
            }
        }
    }
}
