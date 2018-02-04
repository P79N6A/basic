package com.itcast.basic.jdk.lang.thread.buiness;

/**
 * Created by Administrator on 2018/2/3.
 */
public class SysHelloObject {

    private boolean isMain = false;

    public synchronized void sysMain(int num) throws InterruptedException {
        while (true) {
            if (isMain) {
                for (int i = 1; i <= num; i++) {
                    System.out.println("main is " + i);
                }
                isMain = false;
                notify();
            } else {
                wait();
            }
        }
    }

    public synchronized void sysSub(int num) throws InterruptedException {
        while (true) {
            if (isMain) {
                wait();
            } else {
                for (int i = 1; i <= num; i++) {
                    System.out.println("sub is " + i);
                }
                isMain = true;
                notify();
            }
        }

    }
}
