package com.itcast.basic.hibernate.hibernatebasicconfig.domain;

/**
 * Created by qfl on 16/7/6.
 */
public enum Sex {
    MAN("男"), WOMAN("女");
    private String value;

    Sex(String value) {
        this.value = value;
    }
}
