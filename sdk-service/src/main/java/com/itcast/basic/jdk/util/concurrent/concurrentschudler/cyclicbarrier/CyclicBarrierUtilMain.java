package com.itcast.basic.jdk.util.concurrent.concurrentschudler.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by treey.qian on 2018/3/28.
 */
public class CyclicBarrierUtilMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into CyclicBarrierUtilMain");
            CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
                System.out.println("*************finish**************");
            });
            for (int i = 0; i < 3; i++) {
                new Thread(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + "到位等待中......");
                        cyclicBarrier.await();
                        System.out.println("**************" + Thread.currentThread().getName() + "***************");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

            for (int i = 0; i < 2; i++) {
                new Thread(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + "到位等待中......");
                        cyclicBarrier.await();
                        System.out.println("*****************************");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }).start();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
