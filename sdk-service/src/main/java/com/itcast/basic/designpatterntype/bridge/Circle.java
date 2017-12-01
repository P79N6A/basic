package com.itcast.basic.designpatterntype.bridge;

import com.itcast.basic.designpatterntype.bridge.service.DrawAPI;
import com.itcast.basic.designpatterntype.bridge.service.Shape;

public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}