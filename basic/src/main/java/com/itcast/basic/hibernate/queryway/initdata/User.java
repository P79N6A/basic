package com.itcast.basic.hibernate.queryway.initdata;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qfl on 16/7/8.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 123456789l;

    private int id;
    private String name;
    private Sex sex;
    private byte[] bytes;
    private Set orders = new HashSet();

    public User(String name, byte[] bytes, Set orders, Sex sex) {
        this.name = name;
        this.bytes = bytes;
        this.orders = orders;
        this.sex = sex;
    }

    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Set getOrders() {
        return orders;
    }

    public void setOrders(Set orders) {
        this.orders = orders;
    }
}
