package com.itcast.basic.jdk.lang.enumtype.enumtype;

/**
 * Created by Administrator on 2018/2/3.
 */
public enum EnumObject {
    ONE(1), TWO(2), THREE(3) {
        public void sysHello() {
            System.out.println("hello world");
        }
    };

    EnumObject() {

    }

    EnumObject(int value) {
        index = value;
    }

    private int index;
    String name = "enum";
    public static final String value = "number";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
