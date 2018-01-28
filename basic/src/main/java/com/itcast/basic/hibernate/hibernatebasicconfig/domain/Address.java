package com.itcast.basic.hibernate.hibernatebasicconfig.domain;

import java.io.Serializable;

/**
 * Created by qfl on 16/7/6.
 */
public class Address implements Serializable {
    private static final long serialVersionUID = 123456789l;

    private String province;
    private String city;
    private String district;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
}
