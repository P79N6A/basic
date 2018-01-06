package com.itcast.basic.designpatterntype.proxy.dynamicproxy;

import com.itcast.basic.designpatterntype.proxy.dynamicproxy.service.Image;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by treey.qian on 2017/11/29.
 */
public class RealImageDynamicProxy implements InvocationHandler {

    private Image image;

    public RealImageDynamicProxy(Image image) {
        this.image = image;
    }

    public Object newInstance() {
        return Proxy.newProxyInstance(image.getClass().getClassLoader(), image.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy class name is" + proxy.getClass().getName());
        return method.invoke(image, args);
    }


}
