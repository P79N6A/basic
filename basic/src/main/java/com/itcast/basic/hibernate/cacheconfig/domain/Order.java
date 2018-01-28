package com.itcast.basic.hibernate.cacheconfig.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by qfl on 16/7/10.
 */
public class Order implements Serializable {
    private static final long serivalVersionUID = 1234567890l;
    private int id;
    private String number;
    private BigDecimal price;
    private int stocks;

    public Order(String number, BigDecimal price, int stocks) {
        this.number = number;
        this.price = price;
        this.stocks = stocks;
    }

    public Order() {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }
}
