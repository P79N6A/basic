package com.itcast.basic.jdk.overwrite;

/**
 * Created by treey.qian on 2018/1/30.
 */
public class SuperObject {
    protected String name = "admin";

    protected static void sysHello(){
        System.out.println("static hello world SuperObject");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected byte sys() {
        System.out.println("hello world SuperObject");
        return 1;
    }

}
