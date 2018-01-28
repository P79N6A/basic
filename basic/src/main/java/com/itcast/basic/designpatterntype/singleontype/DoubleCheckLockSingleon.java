package com.itcast.basic.designpatterntype.singleontype;

/**
 * Created by qfl on 16/6/2.
 */
public class DoubleCheckLockSingleon {

    private static volatile DoubleCheckLockSingleon doubleCheckLockSingleon;

    private DoubleCheckLockSingleon() {

    }

    public static DoubleCheckLockSingleon getDoubleCheckLockSingleon() {
        if (doubleCheckLockSingleon == null)
            synchronized (DoubleCheckLockSingleon.class) {
                if (doubleCheckLockSingleon == null)
                    doubleCheckLockSingleon = new DoubleCheckLockSingleon();
            }
        return doubleCheckLockSingleon;
    }

    public void connect() {

    }

    public void operate() {

    }
}
