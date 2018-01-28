package com.itcast.basic.hibernate.defaultconfig;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by qfl on 16/7/5.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 2011416842l;
    private int id;
    private String name;
    private Date birthday;
    private Sex sex;
    private String description;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
