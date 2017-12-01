package com.itcast.basic.designpatterntype.singleontype.mocksync;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class Person {
    private String LOCK = "Person";

    public void sysHello() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("Person accept lock");
            Thread.sleep(3000);
            System.out.println("person " + Thread.currentThread().getId() + " say hello world");
        }
    }
}
