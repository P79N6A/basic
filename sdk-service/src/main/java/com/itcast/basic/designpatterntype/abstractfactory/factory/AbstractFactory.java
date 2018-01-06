package com.itcast.basic.designpatterntype.abstractfactory.factory;

import com.itcast.basic.designpatterntype.abstractfactory.service.Color;
import com.itcast.basic.designpatterntype.abstractfactory.service.Shape;

public abstract class AbstractFactory {
    abstract Color getColor(String color);

    abstract Shape getShape(String shape);
}