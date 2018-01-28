package com.itcast.basic.hibernate.hibernateobjectrationalmapper.one2many;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qfl on 16/7/7.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 123456789l;

    private int id;
    private Date birthday;
    private String name;
    private String phone;
    private String school;

    private Set<Order> orders = new HashSet<Order>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public User(Date birthday, String name, String phone, String school, Set orders) {
        this.birthday = birthday;
        this.name = name;
        this.phone = phone;
        this.school = school;
        this.orders = orders;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
