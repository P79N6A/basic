package com.itcast.basic.designpatterntype.bridge;

/**
 * Created by qfl on 16/6/3.
 */
public class SubjectSub implements Subject {
    @Override
    public void operate() {
        System.out.println("进行相关操作");
    }
}
