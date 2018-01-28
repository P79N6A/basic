package com.itcast.basic.threadtype.concurrentthread.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by qfl on 16/4/23.
 */
public class ReadAndWriteDemo {
    public static void main(String[] args) {
        final ReaderAndWriter readerAndWriter = new ReaderAndWriter(10);
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readerAndWriter.read();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    readerAndWriter.write();
                }
            }).start();
        }

    }
}

class ReaderAndWriter {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int data;

    public ReaderAndWriter(int number) {
        data = number;
    }

    public void read() {

        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "读出数据为:" + data--);
            lock.readLock().unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write() {

        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "写入数据为:" + data++);
            lock.writeLock().unlock();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}