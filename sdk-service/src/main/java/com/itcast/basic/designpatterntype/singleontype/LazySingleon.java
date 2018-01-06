package com.itcast.basic.designpatterntype.singleontype;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by treey.qian on 2017/11/28.
 * 本类演示单例模式(单节点下线程安全模式)以下写法性能上无明显差距
 */
public class LazySingleon implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;

    private static LazySingleon lazySingleon;

    private LazySingleon() {

    }

    //使用同步方法构建单例对象(锁对象是类的字节码)
    public static synchronized LazySingleon newInstanceByMethod() {
        if (lazySingleon == null) {
            lazySingleon = new LazySingleon();
        }
        return lazySingleon;
    }

    //使用同步代码块构建单例对象(锁对象是类的字节码)
    public static LazySingleon newInstanceByBlock() {
        synchronized (LazySingleon.class) {
            if (lazySingleon == null) {
                lazySingleon = new LazySingleon();
            }
            return lazySingleon;
        }
    }

    //覆盖反序列化对象
    private Object readResolve() throws ObjectStreamException {
        System.out.println("read resolve start");
        return newInstanceByMethod();
    }


}
