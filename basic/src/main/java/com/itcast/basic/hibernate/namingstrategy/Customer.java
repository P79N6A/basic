package com.itcast.basic.hibernate.namingstrategy;

import java.io.Serializable;

/**
 * Created by qfl on 16/7/5.
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = 2011416842l;

    private int id;

    private String name;

    private Address homeAddress;

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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

}
