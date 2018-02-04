package com.itcast.basic.jdk.classtype.loadclass;

/**
 * Created by Administrator on 2018/2/3.
 */
public class LoadClassMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into LoadClassMain");
            new LoadClassObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
