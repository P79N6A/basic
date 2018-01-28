package com.itcast.basic.classtype.classloader;

public class SubClass extends SuperClass implements ContantUtils{

    public SubClass() {
        super();
        System.out.println("enter SubClass Contructor");
    }

    private static int l = 20;

    static {
        System.out.println("enter SubClass static");
    }

    private int m = 30;

    {
        System.out.println("enter SubClass bolck");
        System.out.println("contant is "+contant);
    }
}
