package com.itcast.basic.hibernate.cacheconfig.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qfl on 16/7/10.
 */
public class User implements Serializable {
    private static final long serivalVersionUID = 123456789l;
    private int id;
    private String name;
    private String sex;
    private Set orders = new HashSet();

    public User(String name, String sex, Set orders) {
        this.name = name;
        this.sex = sex;
        this.orders = orders;
    }

    public User() {
    }

    public static long getSerivalVersionUID() {
        return serivalVersionUID;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Set getOrders() {
        return orders;
    }

    public void setOrders(Set orders) {
        this.orders = orders;
    }
}
