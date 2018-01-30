package com.itcast.basic.jdk.overload;

/**
 * Created by treey.qian on 2018/1/30.
 */
public class NodeObject extends RootObject {

    protected void sysHello(String name, String number) {
        System.out.println("name of NodeObject is " + name + " number=" + number);
    }

    public void sysHello(String name, String number, String address) {
        System.out.println("name of NodeObject is " + name + " number=" + number + " address=" + address);
    }
}
