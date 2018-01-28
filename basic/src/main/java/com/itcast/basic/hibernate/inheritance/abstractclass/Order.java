package com.itcast.basic.hibernate.inheritance.abstractclass;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by qfl on 16/7/8.
 */
public abstract class Order implements Serializable {
    private static final long servialVersionUID = 123456789l;
    private int id;
    private String name;
    private User user;
    private int count;
    private BigDecimal price;

    public Order(String name, User user, int count, BigDecimal price) {
        this.name = name;
        this.user = user;
        this.count = count;
        this.price = price;
    }

    public Order() {
    }

    public static long getServialVersionUID() {
        return servialVersionUID;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
