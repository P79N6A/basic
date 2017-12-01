package com.itcast.basic.designpatterntype.singleontype;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class LazysingleonProxy implements Serializable {

    private static final String LOCK = "lock";

    private static volatile LazysingleonProxy lazySingleonProxy;

    private LazysingleonProxy() {

    }

    //同步块锁定
    public static LazysingleonProxy newInstanceProxy() {
        synchronized (LOCK) {
            if (lazySingleonProxy == null) {
                lazySingleonProxy = new LazysingleonProxy();
            }
        }
        doSomething();
        return lazySingleonProxy;
    }

    private static void doSomething() {
        System.out.println("这里执行很多不确定的耗时操作");
    }

    //覆盖反序列化对象
    private Object readResolve() throws ObjectStreamException {
        System.out.println("read resolve start");
        return newInstanceProxy();
    }

}
