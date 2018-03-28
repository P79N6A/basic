package com.itcast.basic.jdk.util.concurrent.concurrentschudler.model;

import java.io.Serializable;

/**
 * Created by treey.qian on 2018/3/27.
 */
public class Person implements Serializable {
    private int id;
    private String name;
    private String school;
    private String nickName;
    private String sex;
    private String birthCity;
    private String job;
    private String liveCity;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLiveCity() {
        return liveCity;
    }

    public void setLiveCity(String liveCity) {
        this.liveCity = liveCity;
    }

    public Person(int id, String name, String school, String nickName, String sex, String birthCity, String job, String liveCity) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.nickName = nickName;
        this.sex = sex;
        this.birthCity = birthCity;
        this.job = job;
        this.liveCity = liveCity;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthCity='" + birthCity + '\'' +
                ", job='" + job + '\'' +
                ", liveCity='" + liveCity + '\'' +
                '}';
    }
}
