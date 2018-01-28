package com.itcast.basic.hibernate.hibernateobjectrationalmapper.one2one.doublemaperone;

import java.io.Serializable;

/**
 * Created by qfl on 16/7/6.
 */
public class UserInfo implements Serializable {
    private static final long serivalVersionUID = 123456789l;
    private int id;
    private String nickName;
    private int age;
    private String school;
    private String companyName;
    private User user;

    public static long getSerivalVersionUID() {
        return serivalVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
