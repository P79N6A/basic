package com.itcast.basic.javabean.proxytype.dynamictype;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by qfl on 16/4/22.
 */
public class AnimalFactory implements InvocationHandler {

    private Animal animal;

    public AnimalFactory(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态添加的方法");
        method.invoke(animal, args);
        return null;
    }
}
