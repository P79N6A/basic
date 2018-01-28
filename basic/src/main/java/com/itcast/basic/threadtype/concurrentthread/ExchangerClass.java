package com.itcast.basic.threadtype.concurrentthread;

import java.util.concurrent.Exchanger;

/**
 * Created by qfl on 16/4/24.
 */
public class ExchangerClass {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        new ThreadSubber(exchanger).start();
        new ThreadSupper(exchanger).start();
    }
}

class ThreadSupper extends Thread {
    private Exchanger exchanger;

    public ThreadSupper(Exchanger exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String text = (String) exchanger.exchange("hi i am Lily");
            System.out.println("father receive message is " + text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadSubber extends Thread {
    private Exchanger exchanger;

    public ThreadSubber(Exchanger exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String text = (String) exchanger.exchange("hi i am Lucy");
            System.out.println("subber receive message is " + text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}