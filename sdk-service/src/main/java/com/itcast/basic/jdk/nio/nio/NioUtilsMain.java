package com.itcast.basic.jdk.nio.nio;

import com.itcast.basic.jdk.nio.nio.NioChannelUtils;

/**
 * Created by treey.qian on 2018/2/7.
 */
public class NioUtilsMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into NioUtilsMain");
//            NioChannelUtils.openFileChannel("e:\\1.txt");
//            NioChannelUtils.copyToFile("e:\\1.txt","e:\\2.txt");
//            NioChannelUtils.copyFromFile("e:\\1.txt", "e:\\3.txt");
//            NioChannelUtils.mapBigFile("e:\\1.txt");

            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
