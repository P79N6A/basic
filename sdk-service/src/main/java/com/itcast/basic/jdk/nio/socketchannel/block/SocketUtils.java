package com.itcast.basic.jdk.nio.socketchannel.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Administrator on 2018/2/10.
 */
public class SocketUtils {

    /**
     * 创建客户端连接
     *
     * @param host
     * @param port
     */
    public static void startSocketClient(String host, int port) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(host, port));
        //创建字节缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //写入字节数据
        byteBuffer.put("hello i am client".getBytes());
        //切换写模式
        byteBuffer.flip();
        //写入通道
        socketChannel.write(byteBuffer);
        socketChannel.close();
    }

    /**
     * 开启服务器
     *
     * @param port
     * @throws IOException
     */
    public static void startSocketServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            //构造字节缓存区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            socketChannel.read(byteBuffer);
            //读出数据
            System.out.println("text is " + new String(byteBuffer.array()));
            socketChannel.close();
        }
    }


    private SocketUtils() {

    }
}
