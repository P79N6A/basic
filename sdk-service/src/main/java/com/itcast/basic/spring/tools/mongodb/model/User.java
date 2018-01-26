package com.itcast.basic.spring.tools.mongodb.model;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by treey.qian on 2018/1/26.
 */
public class User implements Serializable {
    private int id;
    private String name;
    private String school;
    private String number;

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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
