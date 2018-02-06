package com.itcast.basic.jdk.io.io;

/**
 * Created by treey.qian on 2018/2/5.
 */
public class UtilsMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into UtilsMain");
//            StreamTokenizerUtils.operateStreamTokenizer();
            RandomAccessFileUtils.copyFile("e:\\1.txt");
            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
