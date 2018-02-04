package com.itcast.basic.jdk.classtype.loadclass;

/**
 * Created by Administrator on 2018/2/3.
 */
public abstract class AbstractLoadClassObject {

    private String name;
    private static String value = "0";

    static {
        System.out.println("enter into AbstractLoadClassObject static block value=" + value);
    }

    {
        System.out.println("enter into AbstractLoadClassObject block name=" + name);
    }

    public AbstractLoadClassObject() {
        System.out.println("enter into AbstractLoadClassObject constructor");
    }
}
