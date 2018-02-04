package com.itcast.basic.jdk.lang.thread.bank;

/**
 * Created by Administrator on 2018/2/3.
 */
public class SimpleThread implements Runnable {
    @Override
    public void run() {
        System.out.println("这是一个runnable实现接口的线程");
    }
}
