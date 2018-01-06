package com.itcast.basic.designpatterntype.abstractfactory.factory;

import com.itcast.basic.designpatterntype.abstractfactory.product.Blue;
import com.itcast.basic.designpatterntype.abstractfactory.product.Green;
import com.itcast.basic.designpatterntype.abstractfactory.product.Red;
import com.itcast.basic.designpatterntype.abstractfactory.service.Color;
import com.itcast.basic.designpatterntype.abstractfactory.service.Shape;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        Color colorObj = null;
        if ("blue".equalsIgnoreCase(color)) {
            colorObj = new Blue();
        } else if ("green".equalsIgnoreCase(color)) {
            colorObj = new Green();
        } else if ("red".equalsIgnoreCase(color)) {
            colorObj = new Red();
        }
        return colorObj;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
