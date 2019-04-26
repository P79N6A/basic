package com.itcast.basic.jdk.lang.classloader.classloader;

/**
 * Created by treey.qian on 2018/2/2.
 */
public class ClassFileObject {

    public static final int id = 0;

    static {
        System.out.println("enter into static block");
    }

    {
        System.out.println("enter into   block");
    }

    private String name = "root";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassFileObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
