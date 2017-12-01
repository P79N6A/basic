package com.itcast.basic.designpatterntype.observer.impl;

import com.itcast.basic.designpatterntype.observer.Subject;
import com.itcast.basic.designpatterntype.observer.service.Observer;

public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: "
                + Integer.toOctalString(subject.getState()));
    }
}