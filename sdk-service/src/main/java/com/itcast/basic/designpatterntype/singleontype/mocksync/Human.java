package com.itcast.basic.designpatterntype.singleontype.mocksync;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class Human {
    private String LOCK = "Human";

    public void sysHello() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("Human accept lock");
            Thread.sleep(6000);
            System.out.println("human " + Thread.currentThread().getId() + " say hello world");
        }
    }
}
