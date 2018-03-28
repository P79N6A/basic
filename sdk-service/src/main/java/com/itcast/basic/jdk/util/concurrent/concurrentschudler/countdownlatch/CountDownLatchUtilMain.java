package com.itcast.basic.jdk.util.concurrent.concurrentschudler.countdownlatch;

import java.io.File;

/**
 * Created by treey.qian on 2018/3/27.
 */
public class CountDownLatchUtilMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into CountDownLatchUtilMain");
//            CountDownLatchUtil.downLoad(new File("E:\\person.xls"));
            CountDownLatchUtil.quickDownLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
