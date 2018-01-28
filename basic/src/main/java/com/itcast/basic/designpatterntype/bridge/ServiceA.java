package com.itcast.basic.designpatterntype.bridge;

/**
 * Created by qfl on 16/6/3.
 */
public class ServiceA extends Service {
    public ServiceA(Subject subject) {
        super(subject);
    }

    @Override
    public void systemAll() {
        getSubject().operate();
    }
}
