package com.itcast.basic.spring.jdbc;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by treey.qian on 2017/10/18.
 */
public class Student implements Serializable {
    private int id;
    private String name;
    private String school;
    private Date birth;

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", birth=" + birth +
                '}';
    }
}
