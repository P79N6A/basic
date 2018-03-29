package com.itcast.basic.jdk.util.concurrent.locks.reentrantlock;

import java.util.concurrent.Phaser;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class ReentrantLockUtilMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into ReentrantLockUtilMain");
            Phaser phaser = new Phaser();
            ReentrantLockUtil.unsafe();
            ReentrantLockUtil.safe();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
