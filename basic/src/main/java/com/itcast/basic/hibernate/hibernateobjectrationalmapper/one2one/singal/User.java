package com.itcast.basic.hibernate.hibernateobjectrationalmapper.one2one.singal;

import java.io.Serializable;

/**
 * Created by qfl on 16/7/6.
 */
public class User implements Serializable {
    private final static long serialVersionUID = 123456789l;

    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
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
}
