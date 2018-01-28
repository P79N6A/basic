package com.itcast.basic.designpatterntype.singleontype;

/**
 * Created by qfl on 16/6/2.
 */
public class SynchronizedMethodSingleon {
    private static SynchronizedMethodSingleon synchronizedMethodSingleon;

    public synchronized static SynchronizedMethodSingleon getSynchronizedMethodSingleon() {
        if (synchronizedMethodSingleon == null)
            synchronizedMethodSingleon = new SynchronizedMethodSingleon();
        return synchronizedMethodSingleon;
    }

    private SynchronizedMethodSingleon() {
    }

    public void connect() {

    }

    public void operate() {

    }
}
