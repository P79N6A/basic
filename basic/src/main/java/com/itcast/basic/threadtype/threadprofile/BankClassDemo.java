package com.itcast.basic.threadtype.threadprofile;

/**
 * Created by qfl on 16/4/23.
 * wait和notify只能是one-线程之间的交互
 */
public class BankClassDemo {

    public static void main(String[] args) {
        final Bank bank = new Bank(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                bank.popMoney(100);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                bank.pushMoney(2000);
            }
        }).start();

    }
}

class Bank {

    private int money;

    public Bank(int number) {
        money = number;
    }

    public synchronized void popMoney(int increment) {
        while (true) {
            try {
                while (money <= 0)
                    wait();
                money -= increment;
                System.out.println("线程" + Thread.currentThread().getName() + "取款" + increment + " 账户余额为" + money);
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void pushMoney(int addement) {
        while (true) {
            try {
                while (money > 0)
                    wait();
                money += addement;
                System.out.println("线程" + Thread.currentThread().getName() + "存款" + addement + " 账户余额为" + money);
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}