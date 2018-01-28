package com.itcast.basic.designpatterntype.templte;

/**
 * Created by qfl on 16/6/3.
 */
public abstract class Templte {
    public void operateCore() {
        init();
        operate();
        close();
    }

    protected abstract void init();

    protected abstract void operate();

    protected abstract void close();
}
