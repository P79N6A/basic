package com.itcast.basic.hibernate.abstractconfig;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by qfl on 16/7/5.
 */
@Entity
@Table(name = "t_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 2011416842l;

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "order_number", nullable = true)
    private String orderNumber;

    @Column(name = "order_name")
    private String name;

    @Column(name = "price", scale = 2, precision = 8)
    private BigDecimal price;

    @Column(name = "item_count")
    private int count;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
