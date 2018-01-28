package com.itcast.basic.designpatterntype.prototype;

/**
 * Created by qfl on 16/6/3.
 */
public class Prototype implements Cloneable {
    public Prototype() {

    }

    public Prototype getPrototype() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    public void connect() {

    }

    public void operate() {

    }
}
