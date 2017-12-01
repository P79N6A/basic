package com.itcast.basic.designpatterntype.prototype;

public class Square extends Shape {

    public Square() {
        type = "square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}