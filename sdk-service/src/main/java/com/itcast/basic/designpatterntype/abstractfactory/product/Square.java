package com.itcast.basic.designpatterntype.abstractfactory.product;


import com.itcast.basic.designpatterntype.abstractfactory.service.Shape;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("draw a Square");
    }
}
