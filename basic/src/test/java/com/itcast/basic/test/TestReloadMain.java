package com.itcast.basic.test;

import org.junit.Test;

/**
 * Created by treey.qian on 2017/9/20.
 */
public class TestReloadMain {


    public static void sys(int i) {
        System.out.println("enter int");
    }

    public static void sys(float f) {
        System.out.println("enter float");
    }

    public static void sys(long l) {
        System.out.println("enter long");
    }

    public static void sys(double d) {
        System.out.println("enter double");
    }

    public static void sys(Character character) {
        System.out.println("enter character");
    }


    public static void main(String[] arg) {
        char c = 'a';
        sys(c);
    }

    @Test
    public void testService() {
        int i = 0;
        System.out.println("i++=" + " ++i=" + (++i));
    }

}
