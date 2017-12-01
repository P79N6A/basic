package com.itcast.basic.designpatterntype.factorymethod.factory;

import com.itcast.basic.designpatterntype.factorymethod.product.Circle;
import com.itcast.basic.designpatterntype.factorymethod.product.Rectangle;
import com.itcast.basic.designpatterntype.factorymethod.product.Square;
import com.itcast.basic.designpatterntype.factorymethod.service.Shape;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class ShapeFactory {

    public static Shape newInstance(String type) {
        Shape shape = null;
        if ("circle".equalsIgnoreCase(type)) {
            shape = new Circle();
        } else if ("square".equalsIgnoreCase(type)) {
            shape = new Square();
        } else if ("rectangle".equalsIgnoreCase(type)) {
            shape = new Rectangle();
        }
        return shape;
    }

    public static Object invokeInstance(Class classType) {
        Object shape = null;
        try {
            shape = Class.forName(classType.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("error message is" + e);
        }
        return shape;
    }


}
