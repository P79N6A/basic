package com.itcast.basic.designpatterntype.facade.impl;

import com.itcast.basic.designpatterntype.facade.service.Shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}