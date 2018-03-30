package com.itcast.basic.jdk.util.delayqueue;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class JDKDelayQueueMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKDelayQueueMain");
            int i = 10;
            while (true) {
                int j = i / 0;
            }
        } finally {
            System.out.println("enter into finally");
        }
    }
}
