package com.itcast.basic.threadtype.concurrentthread.singlemodelclass;

/**
 * 线程安全单效率低
 */

public class SynchronziedSingleModelClass {
    public static void main(String[] args) {

    }
}

//(延迟加载)懒汉变形1
class FirstSynchronizedConnectionUtils {
    private static FirstSynchronizedConnectionUtils firstSynchronizedConnectionUtils;

    private synchronized FirstSynchronizedConnectionUtils getFirstSynchronizedConnectionUtils() {
        if (firstSynchronizedConnectionUtils == null)
            firstSynchronizedConnectionUtils = new FirstSynchronizedConnectionUtils();
        return firstSynchronizedConnectionUtils;
    }
}

//(延迟加载)懒汉变形2
class SecondSynchronizedConnectionUtils {
    private static SecondSynchronizedConnectionUtils secondSynchronizedConnectionUtils;

    private static SecondSynchronizedConnectionUtils getSecondSynchronizedConnectionUtils() {
        synchronized (SecondSynchronizedConnectionUtils.class) {
            if (secondSynchronizedConnectionUtils == null)
                secondSynchronizedConnectionUtils = new SecondSynchronizedConnectionUtils();
            return secondSynchronizedConnectionUtils;
        }
    }
}


