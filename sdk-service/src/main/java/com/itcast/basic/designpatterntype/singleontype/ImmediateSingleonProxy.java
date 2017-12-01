package com.itcast.basic.designpatterntype.singleontype;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class ImmediateSingleonProxy implements Serializable {

    //静态域 当且仅当 应用调用时 初始化一次
    private static final ImmediateSingleonProxy immediateSingleonProxy = new ImmediateSingleonProxy();

    private ImmediateSingleonProxy() {

    }

    public static ImmediateSingleonProxy newInstance() {
        return immediateSingleonProxy;
    }

    //覆盖反序列化对象
    private Object readResolve() throws ObjectStreamException {
        System.out.println("read resolve start");
        return immediateSingleonProxy;
    }
}
