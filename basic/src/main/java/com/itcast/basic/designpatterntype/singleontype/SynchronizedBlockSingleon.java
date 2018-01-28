package com.itcast.basic.designpatterntype.singleontype;

/**
 * Created by qfl on 16/6/2.
 */
public class SynchronizedBlockSingleon {
    private static SynchronizedBlockSingleon synchronizedBlockSingleon;

    public static SynchronizedBlockSingleon getSynchronizedBlockSingleon() {
        synchronized (SynchronizedBlockSingleon.class) {
            if (synchronizedBlockSingleon == null)
                synchronizedBlockSingleon = new SynchronizedBlockSingleon();
            return synchronizedBlockSingleon;
        }
    }

    private SynchronizedBlockSingleon() {
    }

    public void connect() {

    }

    public void operate() {

    }
}
