package com.itcast.basic.threadtype.threadprofile;

/**
 * Created by qfl on 16/4/24.
 * 本类将列出尽可能多的线程内部方法:
 * 非静态方法:
 * join强制抢占当前cpu资源运行新加入的线程
 * resume唤醒被suspend方法挂起的线程
 * suspend强制挂起线程
 * 静态方法:
 * yield释放当前线程占有的资源
 * sleep强制当前线程睡眠
 * interrupted强制重置当前线程的中断状态
 */
public class MethodsOfThreadClass {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
