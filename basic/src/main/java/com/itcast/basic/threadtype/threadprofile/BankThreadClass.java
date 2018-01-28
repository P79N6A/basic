package com.itcast.basic.threadtype.threadprofile;

/**
 * Created by qfl on 16/4/22.
 * 主线程和子线程交替输出
 * 子线程循环10次，接着主线程循环100次，接着有回到子线程循环10次，
 * 接着再回到主线程循环100次，如此执行50次
 */
public class BankThreadClass {
    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.sub(i);
                }
            }
        }).start();

        for (int i = 0; i < 50; i++)
            business.main(i);
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++)
                    business.printHello(i);
            }
        }).start();
    }
}

class Business {
    private boolean isMain = false;

    public Business() {
    }

    public void printHello(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method exce is " + (i + 1));
    }

    public Business(boolean isMain) {
        this.isMain = isMain;
    }

    public synchronized void sub(int j) {
        try {
            while (isMain)
                wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("sub print " + i + " outter j is " + j);
        }
        isMain = true;
        notify();
    }

    public synchronized void main(int j) {
        try {
            while (!isMain)
                wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("main print " + i + " outter j is " + j);
        }
        isMain = false;
        notify();
    }

}
