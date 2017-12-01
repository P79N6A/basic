package com.itcast.basic.designpatterntype.decorator;

import com.itcast.basic.designpatterntype.decorator.impl.Circle;
import com.itcast.basic.designpatterntype.decorator.impl.Rectangle;
import com.itcast.basic.designpatterntype.decorator.service.Shape;

/**
 * Created by treey.qian on 2017/11/29.
 */
public class DecoratorServiceClient {

    public static void main(String[] args) {
        try {

            Shape circle = new Circle();

            ShapeDecorator redCircle = new ShapeDecorator(new Circle());

            ShapeDecorator redRectangle = new ShapeDecorator(new Rectangle());
            System.out.println("Circle with normal border");
            circle.draw();

            System.out.println("Circle of red border");
            redCircle.draw();

            System.out.println("Rectangle of red border");
            redRectangle.draw();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
