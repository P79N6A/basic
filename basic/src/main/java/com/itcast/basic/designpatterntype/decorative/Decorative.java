package com.itcast.basic.designpatterntype.decorative;

/**
 * Created by qfl on 16/6/3.
 */
public class Decorative {
    private Subject subject;

    public Decorative(Subject subject) {
        this.subject = subject;
    }

    public void operate() {
        System.out.println("进行额外的操作");
        this.subject.operate();
    }
}
