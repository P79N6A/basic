package com.itcast.basic.designpatterntype.decorator;

import com.itcast.basic.designpatterntype.decorator.service.Shape;

/**
 * Created by treey.qian on 2017/11/29.
 */
public abstract class AbstractShapeDecorator {

    protected Shape decoratedShape;

    public AbstractShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        doSomethingBeforeDraw();
        decoratedShape.draw();
        doSomethingAfterDraw();
    }

    abstract void doSomethingBeforeDraw();

    abstract void doSomethingAfterDraw();
}
