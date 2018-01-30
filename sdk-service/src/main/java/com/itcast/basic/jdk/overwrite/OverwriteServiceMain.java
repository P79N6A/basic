package com.itcast.basic.jdk.overwrite;

/**
 * Created by treey.qian on 2018/1/30.
 */
public class OverwriteServiceMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into OverwriteServiceMain");
            SuperObject subObject = new SubObject();
            subObject.sys();
            subObject.sysHello();
            System.out.println("name is " + subObject.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
