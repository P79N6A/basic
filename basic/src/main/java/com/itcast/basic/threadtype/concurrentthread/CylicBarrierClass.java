package com.itcast.basic.threadtype.concurrentthread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by qfl on 16/4/24.
 */
public class CylicBarrierClass {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("game start....");
            }
        });

        for (int i = 0; i < 3; i++)
            new Player("thread" + i, cyclicBarrier).start();
    }
}

class Player extends Thread {
    private CyclicBarrier cylicBarrier;

    public Player(String name, CyclicBarrier cyclicBarrier) {
        setName(name);
        this.cylicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "到位等待中......");
            cylicBarrier.await();
            System.out.println("*****************************");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
