package com.itcast.basic.designpatterntype.decorative;

/**
 * Created by qfl on 16/6/3.
 */
public class SubjectA implements Subject {
    @Override
    public void operate() {
        System.out.println("操作SubjectA对象");
    }
}
