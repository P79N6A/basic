package com.itcast.basic.designpatterntype.proxytype.dymicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by qfl on 16/6/3.
 */
public class ProxyUtils implements Subject, InvocationHandler {
    private Subject subject;

    public ProxyUtils(Subject subject) {
        this.subject = subject;
    }

    public Object newInstance() {
        return Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(subject, args);
    }

    @Override
    public void operateCore() {
        System.out.println("动态代理方法初始化环境");
        subject.operateCore();
    }
}
