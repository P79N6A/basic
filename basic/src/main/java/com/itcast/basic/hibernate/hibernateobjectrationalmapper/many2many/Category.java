package com.itcast.basic.hibernate.hibernateobjectrationalmapper.many2many;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qfl on 16/7/7.
 */
public class Category implements Serializable {
    private static final long servialVersionUID = 123456789l;
    private int id;
    private String name;
    Set<Product> products = new HashSet<>();

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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
