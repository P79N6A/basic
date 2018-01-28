package com.itcast.basic.designpatterntype.bridge;

/**
 * Created by qfl on 16/6/3.
 */
public abstract class Service {
    private Subject subject;

    public Service(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    protected abstract void systemAll();
}
