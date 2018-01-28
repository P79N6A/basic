package com.itcast.basic.hibernate.namingstrategy;

import java.io.Serializable;

/**
 * Created by qfl on 16/7/5.
 */
public class Address implements Serializable {
    private static final long serivalVersionUID = 2011416842l;

    private String province;
    private String city;
    private String district;

    public static long getSerivalVersionUID() {
        return serivalVersionUID;
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
