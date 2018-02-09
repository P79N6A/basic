package com.itcast.basic.jdk.nio.socketchannel;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by treey.qian on 2018/2/8.
 */
public class SocketChannelBlockUtils {

    /**
     * 打开客户端
     *
     * @param host 地址
     * @param port 端口
     * @throws IOException
     */
    public static void startSocketClient(String host, int port) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(host, port));
        String text = "hello world";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(text.getBytes());
        //切换缓存模式为可写
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        socketChannel.close();
    }

    /**
     * 开启渠道
     *
     * @param port
     * @throws IOException
     */
    public static void startSocketChannel(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            socketChannel.read(byteBuffer);
            byte[] bytes = byteBuffer.array();
            System.out.println("size of buffer is " + bytes.length + " text is " + new String(bytes));
            socketChannel.close();
        }
    }

    private SocketChannelBlockUtils() {

    }
}
