package com.itcast.basic.mybatis.configurationdetail.typehandlerdetail.model;

/**
 * Created by Administrator on 2018/1/7.
 */
public class User {
    private int id;
    private String name;
    private String school;
    private Sex sex;
    private Sex vsex;

    public User(int id, String name, String school, Sex sex, Sex vsex) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.sex = sex;
        this.vsex = vsex;
    }

    public User() {
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Sex getVsex() {
        return vsex;
    }

    public void setVsex(Sex vsex) {
        this.vsex = vsex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", sex=" + sex +
                ", vsex=" + vsex +
                '}';
    }
}
