package com.itcast.basic.spring.rmi.api;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/10/30.
 */
public class Person implements Serializable {

    private String name;

    private String school;

    public Person() {
    }

    public Person(String name, String school) {
        this.name = name;
        this.school = school;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
