package com.itcast.basic;

/**
 * Created by treey.qian on 2018/3/27.
 */
public class TestStatic {
    public static void main(String[] args) {
        try {
            System.out.println("enter into TestStatic ");
            int i = 1;
            i <<= 31;
            System.out.println("i=" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

