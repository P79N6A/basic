package com.itcast.basic.javabean.proxytype.dynamictype;

/**
 * Created by qfl on 16/4/22.
 */
public class Animal implements AnimalAction {
    @Override
    public void jump() {
        System.out.println("jumping");
    }
}
