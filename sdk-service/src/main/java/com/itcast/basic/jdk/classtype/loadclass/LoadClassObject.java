package com.itcast.basic.jdk.classtype.loadclass;

/**
 * Created by Administrator on 2018/2/3.
 */
public class LoadClassObject extends AbstractLoadClassObject {

    private String school;
    private static String index = "0";

    static {
        System.out.println("enter into LoadClassObject static block index=" + index);
    }

    {
        System.out.println("enter into LoadClassObject block school=" + school);
    }

    public LoadClassObject() {
        System.out.println("enter into LoadClassObject constructor");
    }
}
