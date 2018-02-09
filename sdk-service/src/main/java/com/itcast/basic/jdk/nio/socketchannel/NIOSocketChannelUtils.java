package com.itcast.basic.jdk.nio.socketchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by treey.qian on 2018/2/8.
 */
public class NIOSocketChannelUtils {


    /**
     * 创建非阻塞服务器
     *
     * @param port
     */
    public static void startNIOServerSocket(int port) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            System.out.println("start server");
            //当注册的事件到达时，方法返回；否则,该方法会一直阻塞
            int size = selector.select();
            System.out.println("size=" + size);
            Iterator iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socket = server.accept();
                    socket.configureBlocking(false);
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    byteBuffer.put("hello world i am server".getBytes());
                    byteBuffer.flip();
                    socket.write(byteBuffer);
                    socket.register(selector, SelectionKey.OP_WRITE);
                }

                if (selectionKey.isWritable()) {

                }
            }

        }
    }

    /**
     * 创建非阻塞客户端
     *
     * @param host
     * @param port
     */
    public static void startNIOServerClient(String host, int port) {

    }

    private NIOSocketChannelUtils() {

    }
}
