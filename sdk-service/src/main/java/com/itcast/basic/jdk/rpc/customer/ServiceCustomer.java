package com.itcast.basic.jdk.rpc.customer;

import com.itcast.basic.jdk.rpc.transfer.TransferDto;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created by treey.qian on 2018/4/3.
 */
public class ServiceCustomer {


    public Object customer(Class interfaces, InetSocketAddress inetSocketAddress, String beanId) {
        ServiceProxy serviceProxy = new ServiceProxy(interfaces, inetSocketAddress, beanId);
        return serviceProxy.newInstance(interfaces.getClassLoader(), new Class[]{interfaces});
    }

    private class ServiceProxy implements InvocationHandler {
        private Class classType;
        private String beanId;
        private InetSocketAddress inetSocketAddress;

        public ServiceProxy(Class classType, InetSocketAddress inetSocketAddress, String beanId) {
            this.classType = classType;
            this.inetSocketAddress = inetSocketAddress;
            this.beanId = beanId;
        }

        public Object newInstance(ClassLoader loader, Class<?>[] interfaces) {
            return Proxy.newProxyInstance(loader, interfaces, this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = null;
            String classTypeName = classType.getName();
            String methodName = method.getName();
            System.out.println("class name=" + proxy.getClass().getName() + " method name=" + method.getName()
                    + " args=" + Arrays.toString(args) + " classType name=" + classTypeName);
            try {
                Vector vector = new Vector();
                if (args != null) {
                    for (Object arg : args) {
                        vector.add(arg);
                    }
                }
                TransferDto transferDto = new TransferDto(beanId, classTypeName, methodName, vector);
                Socket socket = new Socket();
                socket.connect(inetSocketAddress);
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(transferDto);

                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                result = input.readObject();
                if (socket != null) {
                    socket.close();
                }
                if (output != null) {
                    output.close();
                }
                if (input != null) {
                    input.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}
