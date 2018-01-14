package com.itcast.basic.test.qfl.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/13.
 */
public class Person implements Serializable {

    private int id;

    private String name;

    private String schoolName;

    public Person() {
        System.out.println("enter into no param");
    }

    public Person(String schoolName, String name, int id) {
        System.out.println("enter into params");
        this.schoolName = schoolName;
        this.name = name;
        this.id = id;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
