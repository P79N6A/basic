package com.itcast.basic.hibernate.hibernateobjectrationalmapper.one2many;

import java.io.Serializable;

/**
 * Created by qfl on 16/7/7.
 */
public class Order implements Serializable {
    private int id;
    private String orderNumber;

    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
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
}
