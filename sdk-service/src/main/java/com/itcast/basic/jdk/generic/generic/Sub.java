package com.itcast.basic.jdk.generic.generic;

/**
 * Created by Administrator on 2018/2/3.
 */
public class Sub extends Super<String> {
    public void forEach(String object) {
        System.out.println("Sub forEach");
    }
}
