package com.itcast.basic.jdk.util.concurrent.concurrentschudler.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by treey.qian on 2018/3/28.
 */
public class SemaphoreUtilMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into SemaphoreUtilMain");
            Semaphore semaphore = new Semaphore(2);
            for (int i = 0; i < 10; i++) {
                new Thread(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + "************start");
                        semaphore.acquire();
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "************finish");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
