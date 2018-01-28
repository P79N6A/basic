package com.itcast.basic.designpatterntype.proxytype.staticproxy;

/**
 * Created by qfl on 16/6/3.
 */
public class ProxyUtils implements Subject {
    private Subject subject;

    public ProxyUtils(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void operateCore() {
        System.out.println("初始化系统参数");
        subject.operateCore();
    }
}
