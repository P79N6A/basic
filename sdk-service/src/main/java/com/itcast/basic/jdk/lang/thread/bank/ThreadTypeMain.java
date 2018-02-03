package com.itcast.basic.jdk.lang.thread.bank;

/**
 * Created by Administrator on 2018/2/3.
 */
public class ThreadTypeMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into ThreadTypeMain");
            new Thread(new SimpleThread()).start();
            Bank bank = new Bank(10000);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    bank.popMoney(100);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    bank.pushMoney(100);
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
