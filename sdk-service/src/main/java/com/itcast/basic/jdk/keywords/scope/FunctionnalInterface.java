package com.itcast.basic.jdk.keywords.scope;

/**
 * Created by Administrator on 2018/1/30.
 */

public interface FunctionnalInterface {


    static void sys() {
        System.out.println("sys FunctionnalInterface");
    }

    default void sysHello() {
        System.out.println("sysHello FunctionnalInterface");
    }
}
