package com.itcast.basic.sockettype.socket.server;

/**
 * Created by qfl on 16/4/28.
 */
public class TestMian {
    public static void main(String[] args) {
        new SocketListener(2000).start();
    }
}
