package com.itcast.basic.designpatterntype.prototype;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = "rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
