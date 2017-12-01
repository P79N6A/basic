package com.itcast.basic.designpatterntype.decorator.impl;

import com.itcast.basic.designpatterntype.decorator.service.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}