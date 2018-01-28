package com.itcast.basic.hibernate.inheritance.implementationclass;

import java.io.Serializable;

/**
 * Created by qfl on 16/7/8.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1234567890l;
    private int id;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
