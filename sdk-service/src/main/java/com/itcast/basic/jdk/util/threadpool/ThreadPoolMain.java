package com.itcast.basic.jdk.util.threadpool;

/**
 * Created by qfl on 2018/3/18.
 */
public class ThreadPoolMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into ThreadPoolMain");
            Thread thread = new Thread(null, null, "001", 0);
            Thread thread1 = new Thread(null, null, "001", 0);
            Thread thread2 = new Thread(null, null, "001", 0);
            System.out.println("thread=" + thread + " thread1=" + thread1 + " thread2=" + thread2);
            System.out.println(thread2 == thread1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
