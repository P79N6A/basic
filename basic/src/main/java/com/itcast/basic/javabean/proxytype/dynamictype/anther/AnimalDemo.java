package com.itcast.basic.javabean.proxytype.dynamictype.anther;

/**
 * Created by qfl on 16/4/22.
 */
public class AnimalDemo {
    public static void main(String[] args) {
        AnimalAction animalAction=(AnimalAction)new AnimalFactory().getInstance(new Animal());
        animalAction.eat();
    }
}
