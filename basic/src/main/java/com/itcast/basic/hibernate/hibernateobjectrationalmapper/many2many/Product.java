package com.itcast.basic.hibernate.hibernateobjectrationalmapper.many2many;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qfl on 16/7/7.
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 123456789l;
    private int id;
    private String name;
    Set<Category> categories = new HashSet<>();

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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
