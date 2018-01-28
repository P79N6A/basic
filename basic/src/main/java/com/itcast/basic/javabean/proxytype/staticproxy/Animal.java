package com.itcast.basic.javabean.proxytype.staticproxy;

/**
 * Created by qfl on 16/4/22.
 */
public class Animal implements AnimalAction {

    @Override
    public void jump() {
        System.out.println("jumping");
    }

    @Override
    public void eat() {
        System.out.println("eating");
    }

    @Override
    public void drink() {
        System.out.println("drinking");
    }

    @Override
    public void walk() {
        System.out.println("walking");

    }
}
