package com.itcast.basic.hibernate.hibernateobjectrationalmapper.many2one;

import java.io.Serializable;

/**
 * Created by qfl on 16/7/7.
 */
public class Order implements Serializable {
    private int id;
    private String orderNumber;
    private User user;

    public Order(String orderNumber, User user) {
        this.orderNumber = orderNumber;
        this.user = user;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
