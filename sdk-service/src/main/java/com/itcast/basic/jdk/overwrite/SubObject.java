package com.itcast.basic.jdk.overwrite;

/**
 * Created by treey.qian on 2018/1/30.
 */
public class SubObject extends SuperObject {
    private String name="root";

    public static void sysHello(){
        System.out.println("static hello world SuperObject");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte sys(){
        System.out.println("hello world SubObject");
        return 1;
    }
}
