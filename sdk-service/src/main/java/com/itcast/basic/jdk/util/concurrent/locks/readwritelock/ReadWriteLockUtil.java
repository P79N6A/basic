package com.itcast.basic.jdk.util.concurrent.locks.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class ReadWriteLockUtil {

    public static void writeLock() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        new Thread(() -> {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " begin....");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finish....");
            lock.writeLock().unlock();
        }, "first").start();

        new Thread(() -> {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " begin....");
            System.out.println(Thread.currentThread().getName() + " finish....");
            lock.writeLock().unlock();
        }, "second").start();

    }

    public static void readLock() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        new Thread(() -> {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " begin....");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finish....");
            lock.readLock().unlock();
        }, "first").start();

        new Thread(() -> {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " begin....");
            System.out.println(Thread.currentThread().getName() + " finish....");
            lock.readLock().unlock();
        }, "second").start();

    }
}
