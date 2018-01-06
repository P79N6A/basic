package com.itcast.basic.designpatterntype.abstractfactory;

import com.itcast.basic.designpatterntype.abstractfactory.factory.AbstractFactory;
import com.itcast.basic.designpatterntype.abstractfactory.factory.ColorFactory;
import com.itcast.basic.designpatterntype.abstractfactory.factory.ShapeFactory;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class FactoryProductor {

    public static AbstractFactory getFactory(String type) {
        if ("shape".equalsIgnoreCase(type)) {
            return new ShapeFactory();
        } else if ("color".equalsIgnoreCase(type)) {
            return new ColorFactory();
        }
        return null;
    }

}
