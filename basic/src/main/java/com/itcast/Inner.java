package com.itcast;

/**
 * Created by Administrator on 2019/4/2.
 */
public interface Inner {

    default void sys(){
        System.out.print("ok");
    }
}
