package com.itcast.basic.jdk.util.concurrent.locks.productandconsumer;

import java.util.concurrent.Phaser;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class ProductAndConsumerUtilMain {
    public static void main(String[] args) {
        try {
            Phaser phaser = new Phaser(1);
            System.out.println("enter into ProductAndConsumerUtilMain");
            ProductAndConsumerUtil productAndConsumerUtil = new ProductAndConsumerUtil(1000);
            new Thread(() -> {
                try {
                    productAndConsumerUtil.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    productAndConsumerUtil.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            phaser.arriveAndAwaitAdvance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
