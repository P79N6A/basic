package com.itcast.basic.designpatterntype.factorymethod;

import com.itcast.basic.designpatterntype.factorymethod.factory.ShapeFactory;
import com.itcast.basic.designpatterntype.factorymethod.product.Square;
import com.itcast.basic.designpatterntype.factorymethod.service.Shape;

/**
 * Created by treey.qian on 2017/11/27.
 */
public class FactoryMethodServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into FactoryMethodServiceClient");
            Shape shape = ShapeFactory.newInstance("circle");
            shape.draw();
            Square square = (Square) ShapeFactory.invokeInstance(Square.class);
            square.draw();
        } catch (Exception e) {
            System.out.println("FactoryMethodServiceClient error is" + e);
        }
    }
}
