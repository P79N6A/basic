package com.itcast.basic.designpatterntype.factorymethod.product;

import com.itcast.basic.designpatterntype.factorymethod.service.Shape;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw a rectangle");
    }
}
