package com.itcast.basic.jdk.lang.thread.bank;

/**
 * Created by Administrator on 2018/2/3.
 */
public class Bank {
    private int money;

    public Bank(int money) {
        this.money = money;
    }

    public synchronized void popMoney(int amount) {
        try {
            while (true) {
                if (money < amount) {
                    System.out.println("没钱啦等待存入");
                    wait();
                } else {
                    money -= amount;
                    System.out.println("thread id is " + Thread.currentThread().getId() + "成功取款" + amount + "RMB");
                    notify();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public synchronized void pushMoney(int amount) {
        try {
            while (true) {
                if (money > 0) {
                    wait();
                } else {
                    money += amount;
                    System.out.println("thread id is " + Thread.currentThread().getId() + "成功存款" + amount + "RMB");
                    notify();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
