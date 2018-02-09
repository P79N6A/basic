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
            if (size <= 0) {
                continue;
            }
            System.out.println("size=" + size);
            Iterator iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                    //得到客户端连接通道
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    byteBuffer.put("hello world i am server".getBytes());
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }

                if (selectionKey.isReadable()) {
                    // 服务器可读消息，得到事件发生的socket通道
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    // 穿件读取的缓冲区
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    byte[] data = buffer.array();
                    String msg = new String(data).trim();
                    System.out.println("server receive from client: " + msg);
                    ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
                    channel.write(outBuffer);
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
    public static void startNIOServerClient(String host, int port) throws IOException {
        SocketChannel channel = SocketChannel.open(); // 设置通道为非阻塞
        channel.configureBlocking(false); // 获得一个通道管理器
        Selector selector = Selector.open(); // 客户端连接服务器,其实方法执行并没有实现连接，需要在listen()方法中调
        // 用channel.finishConnect();才能完成连接
        channel.connect(new InetSocketAddress(host, port));
        // 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。
        channel.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
            // 选择一组可以进行I/O操作的事件，放在selector中,客户端的该方法不会阻塞，
            // 这里和服务端的方法不一样，查看api注释可以知道，当至少一个通道被选中时，
            // selector的wakeup方法被调用，方法返回，而对于客户端来说，通道一直是被选中的
            selector.select(); // 获得selector中选中的项的迭代器
            Iterator ite = selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next(); // 删除已选的key,以防重复处理
                ite.remove(); // 连接事件发生
                if (key.isConnectable()) {
                    SocketChannel channel0 = (SocketChannel) key.channel(); // 如果正在连接，则完成连接
                    if (channel0.isConnectionPending()) {
                        channel0.finishConnect();
                    } // 设置成非阻塞
                    channel0.configureBlocking(false);
                    // 在这里可以给服务端发送信息哦
                    channel0.write(ByteBuffer.wrap(new String("hello server!").getBytes()));
                    // 在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
                    channel0.register(selector, SelectionKey.OP_READ); // 获得了可读的事件
                }

                if (key.isReadable()) {
                    SocketChannel channel0 = (SocketChannel) key.channel();
                    // 穿件读取的缓冲区
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel0.read(buffer);
                    byte[] data = buffer.array();
                    String msg = new String(data).trim();
                    System.out.println("client receive msg from server:" + msg);
                    ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
                    channel0.write(outBuffer);
                }
            }
        }
    }

    private NIOSocketChannelUtils() {

    }
}
