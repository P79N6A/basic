package com.itcast.basic.threadtype.concurrentthread.singlemodelclass;

/**
 * Created by qfl on 16/4/25.
 */
public class DoubleCheckLockSingleModelClass {
    public static void main(String[] args) {

    }
}

class DoubleCheckLockConnectionUtils {
    private volatile static DoubleCheckLockConnectionUtils doubleCheckLockConnectionUtils;

    public static DoubleCheckLockConnectionUtils getDoubleCheckLockConnectionUtils() {

        if (doubleCheckLockConnectionUtils == null) {
            synchronized (DoubleCheckLockConnectionUtils.class) {
                if (doubleCheckLockConnectionUtils == null)
                    doubleCheckLockConnectionUtils = new DoubleCheckLockConnectionUtils();
            }

        }
        return doubleCheckLockConnectionUtils;
    }
}

