package com.itcast.basic.test.qfl.service;

/**
 * Created by Administrator on 2018/2/2.
 */
public class Person implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void sys(char[] chars){

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
