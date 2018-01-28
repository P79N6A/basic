package com.itcast.basic.javabean.proxytype.staticproxy;

/**
 * Created by qfl on 16/4/22.
 */
public class AnimalFactory implements AnimalAction {

    private Animal animal;

    public AnimalFactory(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void jump() {
        System.out.println("init jump");
        animal.jump();
        System.out.println("finish jump");
    }

    @Override
    public void eat() {
        System.out.println("init eat");
        animal.eat();
        System.out.println("finish eat");
    }

    @Override
    public void drink() {
        System.out.println("init drink");
        animal.drink();
        System.out.println("finish drink");
    }

    @Override
    public void walk() {
        System.out.println("init walk");
        animal.walk();
        System.out.println("finish walk");
    }
}
