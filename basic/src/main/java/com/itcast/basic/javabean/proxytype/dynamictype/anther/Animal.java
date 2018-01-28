package com.itcast.basic.javabean.proxytype.dynamictype.anther;

/**
 * Created by qfl on 16/4/22.
 */
public class Animal implements AnimalAction {
    @Override
    public void eat() {
        System.out.println("eating");
    }
}
