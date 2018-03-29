package com.itcast.basic.jdk.util.concurrent.concurrentschudler.phaser;

import java.util.concurrent.Phaser;

/**
 * Created by treey.qian on 2018/3/28.
 */
public class PhaserUtil {


    //模拟考试系统
    public static void doExam() {
        Phaser phaser = new Phaser(3) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("**********phase=***********" + phase);
                switch (phase) {
                    case 0:
                        System.out.println("所有考生到齐了，开始考试");
                        return false;
                    case 1:
                        System.out.println("所有考生都做完第一题，继续");
                        return false;
                    case 2:
                        System.out.println("所有考生都做完第二题，继续");
                        return false;
                    case 3:
                        System.out.println("所有考生都做完第三题，继续");
                        return false;
                    case 4:
                        System.out.println("所有考生都正常交卷,考试结束");
                        return true;
                    default:
                        return true;
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "到达考试");
                    phaser.arriveAndAwaitAdvance();

                    System.out.println(Thread.currentThread().getName() + "做第1题时间...");
                    doExercise();
                    System.out.println(Thread.currentThread().getName() + "做第1题完成...");
                    phaser.arriveAndAwaitAdvance();

                    System.out.println(Thread.currentThread().getName() + "做第2题时间...");
                    doExercise();
                    System.out.println(Thread.currentThread().getName() + "做第2题完成...");
                    phaser.arriveAndAwaitAdvance();

                    System.out.println(Thread.currentThread().getName() + "做第3题时间...");
                    doExercise();
                    System.out.println(Thread.currentThread().getName() + "做第3题完成...");
                    phaser.arriveAndAwaitAdvance();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    private static void doExercise() throws InterruptedException {
        Thread.sleep(2000);
    }

    //提供cycliBarrier功能
    public static void cycliBarrier() {
        Phaser phaser = new Phaser(4) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("人都齐了 开始打麻将吧");
                return super.onAdvance(phase, registeredParties);
            }
        };

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 准时到了");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + " 搓麻将中....");
            }).start();
        }

    }

    //提供countDownLatch功能
    public static void countDownLatch() {
        Phaser phaser = new Phaser(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " begin");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + " finish");
            }).start();
        }

        phaser.register();
        System.out.println("main thread blocking");
        while (!phaser.isTerminated()) {
            phaser.arriveAndDeregister();
        }
    }
}
