package com.itcast.basic.designpatterntype.decorator;

import com.itcast.basic.designpatterntype.decorator.service.Shape;

/**
 * Created by treey.qian on 2017/11/29.
 */
public class ShapeDecorator extends AbstractShapeDecorator {

    public ShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void doSomethingBeforeDraw() {
        System.out.println("do something before draw");
    }

    @Override
    public void doSomethingAfterDraw() {
        System.out.println("do something after draw");
    }
}
