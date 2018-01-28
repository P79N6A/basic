package com.itcast.basic.hibernate.queryway.initdata;

import java.io.Serializable;

/**
 * Created by qfl on 16/7/6.
 */
public class Address implements Serializable {
    private static final long serialVersionUID = 123456789l;

    private int id;
    private String province;
    private String city;
    private String district;

    public User user;

    public Address(String province, User user, String district, String city) {
        this.province = province;
        this.user = user;
        this.district = district;
        this.city = city;
    }

    public Address() {
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
