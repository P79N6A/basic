package com.itcast.basic.designpatterntype.facade;

import com.itcast.basic.designpatterntype.facade.impl.Circle;
import com.itcast.basic.designpatterntype.facade.impl.Rectangle;
import com.itcast.basic.designpatterntype.facade.impl.Square;
import com.itcast.basic.designpatterntype.facade.service.Shape;

/**
 * Created by treey.qian on 2017/11/29.
 */
public class ShapeFacade {

    public ShapeFacade() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }


    private Shape circle;
    private Shape rectangle;
    private Shape square;


    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}
