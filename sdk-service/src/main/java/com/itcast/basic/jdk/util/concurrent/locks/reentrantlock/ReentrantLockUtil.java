package com.itcast.basic.jdk.util.concurrent.locks.reentrantlock;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class ReentrantLockUtil {
    private static String name;


    public static void safe() {
        Phaser phaser = new Phaser(10);
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    phaser.arriveAndAwaitAdvance();
                    lock.lock();
                    Thread.sleep(new Random().nextInt(10));
                    name = Thread.currentThread().getName();
                    System.out.println("safe name=" + name);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void unsafe() {
        Phaser phaser = new Phaser(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    phaser.arriveAndAwaitAdvance();
                    Thread.sleep(new Random().nextInt(10));
                    name = Thread.currentThread().getName();
                    System.out.println("unsafe name=" + name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
