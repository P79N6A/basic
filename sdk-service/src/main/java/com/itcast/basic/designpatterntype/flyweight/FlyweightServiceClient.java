package com.itcast.basic.designpatterntype.flyweight;

import com.itcast.basic.designpatterntype.flyweight.impl.Circle;

public class FlyweightServiceClient {
    private static final String colors[] =
            {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {

        try {
            for (int i = 0; i < 20; ++i) {
                Circle circle =
                        (Circle) ShapeFactory.getCircle(getRandomColor());
                circle.setX(getRandomX());
                circle.setY(getRandomY());
                circle.setRadius(100);
                circle.draw();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}