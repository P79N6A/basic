package com.itcast.basic.designpatterntype.proxytype.staticproxy;

/**
 * Created by qfl on 16/6/3.
 */
public class SubjectSub implements Subject {
    @Override
    public void operateCore() {
        System.out.println("执行被代理类的核心方法");
    }
}
