package com.itcast.basic.jdk.lang.reflect.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by treey.qian on 2018/2/1.
 */
public final class ProductServiceProxy implements InvocationHandler {

    private static Object target;

    /**
     * 生成代理方法
     *
     * @param object 被代理对象
     * @return 返回代理对象
     */
    public static Object newProxyInstance(Object object) {
        InvocationHandler invocationHandler = new ProductServiceProxy(object);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocationHandler);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置处理");
        Object result = method.invoke(target);
        System.out.println("后置处理");
        return result;
    }

    private ProductServiceProxy(Object object) {
        this.target = object;
    }
}
