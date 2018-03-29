package com.itcast.basic.jdk.util.concurrent.concurrentschudler.phaser;

/**
 * Created by treey.qian on 2018/3/28.
 */
public class PhaserUtilMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into PhaserUtilMain");
//            PhaserUtil.countDownLatch();
//            PhaserUtil.cycliBarrier();
            PhaserUtil.doExam();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
