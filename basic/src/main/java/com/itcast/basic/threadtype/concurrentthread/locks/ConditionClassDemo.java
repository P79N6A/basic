package com.itcast.basic.threadtype.concurrentthread.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qfl on 16/4/23.
 * 线程调度系统
 */
public class ConditionClassDemo {
    public static void main(String[] args) {
        final ThreadManageUtils threadManageUtils = new ThreadManageUtils("sun");
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadManageUtils.mainClass();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadManageUtils.sunClass();
            }
        }).start();
        threadManageUtils.supperClass();
    }
}

class ThreadManageUtils {

    private static String name;
    private ReentrantLock lock = new ReentrantLock();
    private Condition supperCondition = lock.newCondition();
    private Condition mainCondition = lock.newCondition();
    private Condition sunCondition = lock.newCondition();

    public ThreadManageUtils(String name) {
        this.name = name;
    }

    public void supperClass() {
        while (true)
            try {
                lock.lock();
                while (!name.equals("supper"))
                    supperCondition.await();
                System.out.println("supper class exce");
                name = "main";
                mainCondition.signal();
                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void mainClass() {
        while (true)
            try {
                lock.lock();
                while (!name.equals("main"))
                    mainCondition.await();
                System.out.println("main class exce");
                name = "sun";
                sunCondition.signal();
                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void sunClass() {
        while (true)
            try {
                lock.lock();
                while (!name.equals("sun"))
                    sunCondition.await();
                System.out.println("sun class exce");
                name = "supper";
                supperCondition.signal();
                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}