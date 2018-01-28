package com.itcast.basic.hibernate.queryway.initdata;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qfl on 16/7/8.
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 123456789l;
    private int id;
    private String number;
    private BigDecimal price;
    private Set items = new HashSet();

    public Order(String number, BigDecimal price, Set items) {
        this.number = number;
        this.price = price;
        this.items = items;
    }

    public Order() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set getItems() {
        return items;
    }

    public void setItems(Set items) {
        this.items = items;
    }
}
