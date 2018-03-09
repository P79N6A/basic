package com.itcast.basic.datastruct.datatree;

/**
 * Created by treey.qian on 2018/3/8.
 */
public enum ColorModel {

    RED("red", 0), BLACK("black", 1);

    private String color;
    private int index;

    ColorModel(String color, int index) {
        this.color = color;
        this.index = index;
    }

    public String getColor() {
        return color;
    }

    public int getIndex() {
        return index;
    }
}
