package com.itcast.basic.hibernate.propertiesconfig;

import java.io.Serializable;

/**
 * Created by qfl on 16/7/5.
 */
public class UserInfo implements Serializable {
    private static final long serivalVersionUID = 20140607l;

    private int id;

    private String description;

    private String number;

    private String school;

    private Name name;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public static long getSerivalVersionUID() {
        return serivalVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
