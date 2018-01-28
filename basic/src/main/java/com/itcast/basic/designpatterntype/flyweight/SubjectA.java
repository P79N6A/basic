package com.itcast.basic.designpatterntype.flyweight;

/**
 * Created by qfl on 16/6/3.
 */
public class SubjectA implements Subject {
    private String name;

    public SubjectA() {

    }

    public SubjectA(String name) {
        this.name = name;
    }

    @Override
    public void operate() {
        System.out.println("进行相关操作");
    }
}
