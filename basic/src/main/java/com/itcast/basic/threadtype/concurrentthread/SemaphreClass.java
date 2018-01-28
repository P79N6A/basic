package com.itcast.basic.threadtype.concurrentthread;

import java.util.concurrent.Semaphore;

/**
 * Created by qfl on 16/4/24.
 */
public class SemaphreClass {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        final BankWindow bankWindow = new BankWindow(semaphore);
        for (int i = 0; i < 5; i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    bankWindow.pushMoney();
                }
            }).start();
    }
}

class BankWindow {
    private Semaphore semaphore;

    public BankWindow(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void pushMoney() {
        try {
            System.out.println("当前窗口正在处理业务,请稍后.......");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "你好我可以处理你的业务........");
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + "的业务处理完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}