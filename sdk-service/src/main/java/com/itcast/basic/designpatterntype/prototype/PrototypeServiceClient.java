package com.itcast.basic.designpatterntype.prototype;

public class PrototypeServiceClient {

    public static void main(String[] args) {
        try {
            ShapeCache.loadCache();

            Shape rectangle = ShapeCache.getShape("rectangle");
            System.out.println("Shape : " + rectangle);

            Shape square = ShapeCache.getShape("square");
            System.out.println("Shape : " + square);

            Shape circle = ShapeCache.getShape("circle");
            System.out.println("Shape : " + circle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}