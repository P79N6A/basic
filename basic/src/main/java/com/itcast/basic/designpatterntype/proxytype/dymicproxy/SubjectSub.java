package com.itcast.basic.designpatterntype.proxytype.dymicproxy;

/**
 * Created by qfl on 16/6/3.
 */
public class SubjectSub implements Subject {
    @Override
    public void operateCore() {
        System.out.println("代理方法的核心操作");
    }
}
