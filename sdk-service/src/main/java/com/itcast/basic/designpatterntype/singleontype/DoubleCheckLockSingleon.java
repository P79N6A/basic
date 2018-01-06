package com.itcast.basic.designpatterntype.singleontype;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class DoubleCheckLockSingleon implements Serializable {

    private static final String LOCK = "lock";

    private static volatile DoubleCheckLockSingleon doubleCheckLockSingleon;

    private DoubleCheckLockSingleon() {

    }

    public static DoubleCheckLockSingleon newInstance() {
        if (doubleCheckLockSingleon == null) {
            synchronized (LOCK) {
                if (doubleCheckLockSingleon == null) {
                    doubleCheckLockSingleon = new DoubleCheckLockSingleon();
                }
            }
        }
        return doubleCheckLockSingleon;
    }

    //覆盖反序列化对象
    private Object readResolve() throws ObjectStreamException {
        System.out.println("read resolve start");
        return newInstance();
    }
}
