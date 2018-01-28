package com.itcast.basic.threadtype.concurrentthread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by qfl on 16/4/24.
 */
public class CountDownLatchClass {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 4; i++) {
            new Runner("runner" + i, countDownLatch).start();
        }
        for (int i = 0; i < 3; i++)
            countDownLatch.countDown();
    }
}

class Runner extends Thread {

    private CountDownLatch countDownLatch;

    public Runner(String name, CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        setName(name);
    }

    public void walk() {
        try {
            System.out.println(getName() + "已到达,准备起跑");
            countDownLatch.await();
            Thread.sleep(1000);
            System.out.println("完成任务");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        walk();
    }
}