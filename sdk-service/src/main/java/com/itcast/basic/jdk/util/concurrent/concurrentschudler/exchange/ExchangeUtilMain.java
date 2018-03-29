package com.itcast.basic.jdk.util.concurrent.concurrentschudler.exchange;

import java.util.concurrent.Exchanger;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class ExchangeUtilMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into ExchangeUtilMain");
            Exchanger exchanger = new Exchanger();
            new Thread(() -> {
                try {
                    Object receiveText = ExchangerUtil.exchangeData(exchanger, "i am lily");
                    System.out.println("receiveText=" + receiveText);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    Object receiveText = ExchangerUtil.exchangeData(exchanger, "hello,i am tim,i love you");
                    System.out.println("receiveText=" + receiveText);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
