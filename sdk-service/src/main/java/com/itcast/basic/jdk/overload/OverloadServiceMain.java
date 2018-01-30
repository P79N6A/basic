package com.itcast.basic.jdk.overload;

/**
 * Created by treey.qian on 2018/1/30.
 */
public class OverloadServiceMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into OverloadServiceMain");
            NodeObject nodeObject = new NodeObject();
            nodeObject.sysHello("treey");
            nodeObject.sysHello("admin", "123456789");
            nodeObject.sysHello("root", "123456789", "wuhan");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
