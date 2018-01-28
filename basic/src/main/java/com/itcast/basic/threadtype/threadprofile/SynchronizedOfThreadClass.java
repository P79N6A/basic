package com.itcast.basic.threadtype.threadprofile;

/**
 * Created by qfl on 16/4/22.
 * 对sleep()方法和wait()方法的思考:
 * Thread.sleep()方法是线程Thread所特有的方法 该方法阻塞当前线程并且不释放当前占有的锁 所有执行该方法的线程都将被阻塞
 * wait()方法为所有(Object)对象所拥有 阻塞时不会暂用锁 必须包含在同步块或者同步方法中
 */
public class SynchronizedOfThreadClass {
    public static void main(String[] args) {
        final SynchronizedOfThreadClass synchronizedOfThread = new SynchronizedOfThreadClass();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronizedOfThread.addId();
                }
            }).start();
        }
        System.out.println("-----------------------------------------------------------");
        int i = 0;
        while (++i < 100) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronizedOfThread.addCode();
                }
            }).start();
        }
        synchronizedOfThread.addCode();
        System.out.println("Main Thread Exce");
    }

    private int id = 0;
    private int code = 0;

    public synchronized void addId() {
        System.out.println("the value of id is " + id++);
    }

    public void addId(int value) {
        synchronized (this) {
            id += value;
        }
        System.out.println("the value of id is " + id);
    }

    public void addId(Object o) {
        synchronized (o) {
            System.out.println("the value of id is " + id++);
        }
    }

    public void addId(int i, int j) {
        synchronized (SynchronizedOfThreadClass.class) {
            System.out.println("the value of id is " + (id + i + i));
        }
    }

    public void addCode() {
        try {
            System.out.println("Thread name is " + Thread.currentThread().getName());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("the value of code is " + code++);
    }
}
