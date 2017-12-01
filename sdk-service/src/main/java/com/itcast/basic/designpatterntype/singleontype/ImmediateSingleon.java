package com.itcast.basic.designpatterntype.singleontype;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class ImmediateSingleon implements Serializable {

    private final static ImmediateSingleon immediateSingleon;

    private ImmediateSingleon() {

    }

    static {
        //静态代码块 当且仅当应用调用时 初始化一次
        immediateSingleon = new ImmediateSingleon();
    }

    public static ImmediateSingleon newInstance() {
        return immediateSingleon;
    }

    //覆盖反序列化对象
    private Object readResolve() throws ObjectStreamException {
        System.out.println("read resolve start");
        return immediateSingleon;
    }
}
