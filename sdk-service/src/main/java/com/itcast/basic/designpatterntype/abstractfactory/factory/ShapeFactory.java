package com.itcast.basic.designpatterntype.abstractfactory.factory;

import com.itcast.basic.designpatterntype.abstractfactory.product.Circle;
import com.itcast.basic.designpatterntype.abstractfactory.product.Rectangle;
import com.itcast.basic.designpatterntype.abstractfactory.product.Square;
import com.itcast.basic.designpatterntype.abstractfactory.service.Color;
import com.itcast.basic.designpatterntype.abstractfactory.service.Shape;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        Shape shape1 = null;
        if ("circle".equalsIgnoreCase(shape)) {
            shape1 = new Circle();
        } else if ("square".equalsIgnoreCase(shape)) {
            shape1 = new Square();
        } else if ("rectangle".equalsIgnoreCase(shape)) {
            shape1 = new Rectangle();
        }
        return shape1;
    }
}
