package com.itcast.basic.hibernate.queryway.initdata;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by qfl on 16/7/8.
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 123456789l;
    private int id;
    private String name;
    private BigDecimal singalPrice;
    private String description;
    private Integer stocks;
    private Integer stocksValue;

    public Item(String name, BigDecimal singalPrice, String description, Integer stocks) {
        this.name = name;
        this.singalPrice = singalPrice;
        this.description = description;
        this.stocks = stocks;
    }

    public Item() {
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

    public BigDecimal getSingalPrice() {
        return singalPrice;
    }

    public void setSingalPrice(BigDecimal singalPrice) {
        this.singalPrice = singalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStocks() {
        return stocks;
    }

    public Integer getStocksValue() {
        return stocksValue;
    }

    private void setStocksValue(Integer stocksValue) {
        this.stocksValue = stocksValue;
    }

    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }


}
