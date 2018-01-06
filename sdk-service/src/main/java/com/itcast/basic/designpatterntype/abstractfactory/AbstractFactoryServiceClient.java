package com.itcast.basic.designpatterntype.abstractfactory;


import com.itcast.basic.designpatterntype.abstractfactory.factory.AbstractFactory;
import com.itcast.basic.designpatterntype.abstractfactory.factory.ShapeFactory;
import com.itcast.basic.designpatterntype.abstractfactory.service.Color;
import com.itcast.basic.designpatterntype.abstractfactory.service.Shape;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class AbstractFactoryServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into AbstractFactoryServiceClient");
            ShapeFactory shapeFactory = (ShapeFactory) FactoryProductor.getFactory("shape");
            Shape shape = shapeFactory.getShape("circle");
            shape.draw();
        } catch (Exception e) {
            System.out.println("error message is" + e);
        }
    }
}
