package com.itcast.basic.sockettype.socket.client;

/**
 * Created by qfl on 16/4/28.
 */
public class ClientStartClass {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ClientBean clientBean = new ClientBean();
                ClientBeanUtils.getInstance().setClient(clientBean);
            }
        }).start();
    }
}
