package com.itcast.basic.designpatterntype.bridge;

import com.itcast.basic.designpatterntype.bridge.impl.GreenCircle;
import com.itcast.basic.designpatterntype.bridge.impl.RedCircle;
import com.itcast.basic.designpatterntype.bridge.service.Shape;

public class BridgeServiceClient {
    public static void main(String[] args) {
        try {
            Shape redCircle = new Circle(100, 100, 10, new RedCircle());
            Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

            redCircle.draw();
            greenCircle.draw();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}