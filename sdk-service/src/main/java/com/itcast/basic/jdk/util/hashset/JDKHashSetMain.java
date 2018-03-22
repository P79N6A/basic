package com.itcast.basic.jdk.util.hashset;

/**
 * Created by treey.qian on 2018/3/22.
 */
public class JDKHashSetMain {


    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKHashSetMain");
            JDKHashSet jdkHashSet = new JDKHashSet();
            jdkHashSet.add("root");
            jdkHashSet.add("root");
            System.out.println("jdkHashSet=" + jdkHashSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
