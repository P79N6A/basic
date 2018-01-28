package com.itcast.basic.javabean.proxytype.dynamictype;

import java.lang.reflect.Proxy;

/**
 * Created by qfl on 16/4/22.
 */
public class AnimalDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        AnimalFactory factory = new AnimalFactory(animal);
        AnimalAction actionAnimal = (AnimalAction) Proxy.newProxyInstance(animal.getClass().getClassLoader(), animal.getClass().getInterfaces(), factory);
        actionAnimal.jump();
    }
}
