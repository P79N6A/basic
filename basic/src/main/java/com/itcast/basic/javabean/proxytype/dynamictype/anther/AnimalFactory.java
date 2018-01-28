package com.itcast.basic.javabean.proxytype.dynamictype.anther;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by qfl on 16/4/22.
 */
public class AnimalFactory implements InvocationHandler {
    private  Animal animal;

    public Object getInstance(Animal animal) {
        this.animal = animal;
        return Proxy.newProxyInstance(animal.getClass().getClassLoader(), animal.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("init eating");
        method.invoke(animal, args);
        return null;
    }
}
