package com.itcast.basic.hibernate.usertypeconfig;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by qfl on 16/7/5.
 */
public class OrderList implements Serializable {
    private static final long serialVersionUID = 123456789l;

    private int id;
    private String name;
    private String number;
    private BigDecimal price;
    private Integer count;

    private AddressType address;

    public AddressType getAddress() {
        return address;
    }

    public void setAddress(AddressType address) {
        this.address = address;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getAllPrice() {
        return price.multiply(new BigDecimal(count));
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public OrderList(Integer count, String name, String number, BigDecimal price) {
        this.count = count;
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public OrderList() {
    }
}
