package com.itcast.basic.jdk.nio.socketchannel.noblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by Administrator on 2018/2/10.
 */
public class NIOSocketChannelUtils {


    /**
     * 创建客户端连接
     *
     * @param hozt
     * @param port
     */
    public static void startNIOSocketClient(String hozt, int port) throws IOException {
        //创建事件监听器
        Selector selector = Selector.open();
        //开启通道连接
        SocketChannel socketChannel = SocketChannel.open();
        //配置非阻塞
        socketChannel.configureBlocking(false);
//        //连接服务器
        socketChannel.connect(new InetSocketAddress(hozt, port));
        //注册连接事件
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        //开启客户端监听器
        clientListener(selector);
    }

    /**
     * 事件监听器
     *
     * @param selector
     */
    private static void clientListener(Selector selector) throws IOException {
        while (true) {
            //获取当前通道已就绪事件个数
            int count = selector.select();
            if (count <= 0) {
                continue;
            }
            Iterator iterators = selector.selectedKeys().iterator();
            while (iterators.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) iterators.next();
                if (selectionKey.isConnectable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    if (socketChannel.isConnectionPending()) {
                        socketChannel.finishConnect();
                    }
                    socketChannel.configureBlocking(false);
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    byteBuffer.put("你好 我是客户端 我在连接你".getBytes());
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }

                //处理读就绪事件
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //初始化缓冲区
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    //读出数据到通道
                    socketChannel.read(byteBuffer);
                    //打印服务器发送数据
                    System.out.println("client receive message is " + new String(byteBuffer.array()));
                    socketChannel.register(selector, SelectionKey.OP_WRITE);
                }

//                //处理写就绪事件
                if (selectionKey.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    byteBuffer.put("你好 我是客户端 这是我发的数据 ***********".getBytes());
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                iterators.remove();
            }
        }
    }

    /**
     * 开启非阻塞服务
     *
     * @param port
     */
    public static void startNIOServerSocket(int port) throws IOException {
        //多路复用注册器(观察者)
        Selector selector = Selector.open();
        //开启服务
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //配置非阻塞
        serverSocketChannel.configureBlocking(false);
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(port));
        //注册可连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //事件开启监听器
        serverListener(selector);
    }

    /**
     * 服务监听器
     *
     * @param selector
     * @throws IOException
     */
    private static void serverListener(Selector selector) throws IOException {
        while (true) {
            //获取通道已注册事件的监听器
            int count = selector.select();
            if (count <= 0) {
                continue;
            }
            System.out.println("服务开启,当前存在的事件监听器个数" + count);
            Iterator iterators = selector.selectedKeys().iterator();
            //迭代已就绪事件
            while (iterators.hasNext()) {
                //得到监听器事件对
                SelectionKey selectionKey = (SelectionKey) iterators.next();
                //处理服务器已就绪事件
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    //得到客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //配置渠道为非阻塞
                    socketChannel.configureBlocking(false);
                    //构造缓冲区
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    //写入数据
                    byteBuffer.put("你好 我是服务器 我即将发送数据给你 ".getBytes());
                    //切换缓冲区模式
                    byteBuffer.flip();
                    //向客户端发送数据
                    socketChannel.write(byteBuffer);
                    //注册读就绪事件
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                //处理读就绪事件
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //初始化缓冲区
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    //读出数据到通道
                    socketChannel.read(byteBuffer);
                    //打印服务器发送数据
                    System.out.println("server receive message is " + new String(byteBuffer.array()));
                    //注册写事件
                    socketChannel.register(selector, SelectionKey.OP_WRITE);
                }

//                //处理写就绪事件
                if (selectionKey.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    byteBuffer.put("你好 我是服务器 这是我发的数据 ***********".getBytes());
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                    //注册读事件
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                iterators.remove();
            }
        }
    }


    private NIOSocketChannelUtils() {

    }
}
