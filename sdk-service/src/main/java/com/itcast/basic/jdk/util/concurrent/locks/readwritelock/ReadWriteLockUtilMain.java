package com.itcast.basic.jdk.util.concurrent.locks.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class ReadWriteLockUtilMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into ReadWriteLockUtilMain");
            ReadWriteLockUtil.writeLock();
            synchronized (ReadWriteLockUtilMain.class) {
                ReadWriteLockUtilMain.class.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
