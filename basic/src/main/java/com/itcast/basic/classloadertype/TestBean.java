package com.itcast.basic.classloadertype;

/**
 * Created by qfl on 16/5/13.
 */
public class TestBean {

    private int id;
    private String name;
    private char sex;

    public TestBean() {
        System.out.println("enter into TestBean");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + sex;
    }

}
