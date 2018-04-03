package com.itcast.basic.jdk.rpc.provider;

import com.itcast.basic.jdk.rpc.service.impl.UserServiceImpl;
import com.itcast.basic.jdk.rpc.transfer.TransferDto;
import org.apache.commons.collections.map.HashedMap;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Vector;

/**
 * Created by treey.qian on 2018/4/3.
 */
public class ServiceProvider {

    private final Map<String, Object> factory = new HashedMap();
    private final Map<String, String> relation = new HashedMap();

    public ServiceProvider() {
        factory.put("userServiceImpl", new UserServiceImpl());
        relation.put("userServiceImpl", factory.get("userServiceImpl").getClass().getName());
    }

    public void listen(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                doWork(serverSocket.accept());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doWork(Socket socket) {
        new Thread(() -> {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Object object = objectInputStream.readObject();
                System.out.println("instance is " + (object instanceof TransferDto));
                if (object instanceof TransferDto) {
                    TransferDto transferDto = (TransferDto) object;
                    String className = relation.get(transferDto.getBeanId());
                    Class invokeClass = Class.forName(className);
                    System.out.println("transferDto=" + transferDto + " className=" + className);
                    Object instance = invokeClass.newInstance();
                    Class[] parameterTypes = new Class[]{};
                    Object[] args = new Object[]{};
                    Vector vector = transferDto.getParams();
                    if (!vector.isEmpty()) {
                        int size = vector.size();
                        parameterTypes = new Class[size];
                        args = new Object[size];
                        for (int i = 0; i < size; i++) {
                            Object o = vector.get(i);
                            parameterTypes[i] = o.getClass();
                            args[i] = o;
                        }
                    }
                    Method method = invokeClass.getMethod(transferDto.getMethodName(), parameterTypes);
                    Object result = method.invoke(instance, args);
                    result = result == null ? "success" : result;
                    new ObjectOutputStream(socket.getOutputStream()).writeObject(result);
                    if (socket != null) {
                        socket.close();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
