package com.itcast.basic.hibernate.hibernateobjectrationalmapper.one2one.doublemaperone;

import java.io.Serializable;

/**
 * Created by qfl on 16/7/6.
 */
public class User implements Serializable {
    private final static long serialVersionUID = 123456789l;

    private int id;
    private String name;
    private UserInfo userInfo;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo info) {
        this.userInfo = info;
    }
}
