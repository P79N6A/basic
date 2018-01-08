package com.itcast.basic.designpatterntype.bridge.impl;

import com.itcast.basic.designpatterntype.bridge.service.DrawAPI;

public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}