package com.itcast.basic.hibernate.queryway.initdata;

/**
 * Created by qfl on 16/7/10.
 */
public enum Sex {
    MAN("男"), WOMAN("女");
    private String value;

    Sex(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
