package com.itcast.basic.mybatis.mapperdetail.resultmapdetail.model;


/**
 * Created by treey.qian on 2018/1/10.
 */
public class Student {
    private long id;
    private String name;
    private Sex sex;
    private String number;
    private String schoolName;

    public Student(Long id, String name, Sex sex, String number, String schoolName) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.number = number;
        this.schoolName = schoolName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", number='" + number + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
