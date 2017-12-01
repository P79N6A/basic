package com.itcast.basic.designpatterntype.observer.service;

import com.itcast.basic.designpatterntype.observer.Subject;

/**
 * Created by treey.qian on 2017/11/30.
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
