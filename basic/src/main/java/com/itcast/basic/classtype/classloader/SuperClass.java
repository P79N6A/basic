package com.itcast.basic.classtype.classloader;

/**
 * Created by qfl on 16/4/21.
 */
public class SuperClass {

    public SuperClass() {
        System.out.println("enter SuperClass Contructor");
    }

    private static int i;
    private static int k = 90;

    static {
        System.out.println("enter first SuperClass static block");
        System.out.println("value of i is " + i);
        System.out.println("value of k is " + k);
    }

    private int j = 100;

    {
        System.out.println("enter second SuperClass bolck");
    }

}
