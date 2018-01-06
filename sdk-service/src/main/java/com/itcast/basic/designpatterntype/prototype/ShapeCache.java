package com.itcast.basic.designpatterntype.prototype;

import java.util.Hashtable;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable();

    public static Shape getShape(String type) {
        Shape cachedShape = shapeMap.get(type);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        shapeMap.put(circle.getType(), circle);

        Square square = new Square();
        shapeMap.put(square.getType(), square);

        Rectangle rectangle = new Rectangle();
        shapeMap.put(rectangle.getType(), rectangle);
    }

}
