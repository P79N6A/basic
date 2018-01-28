package com.itcast.basic.mybatis.mybatisspring.transactionmanager.model;

/**
 * Created by treey.qian on 2018/1/8.
 */
public class User {
    private long id;
    private String name;
    private String school;
    private String nickName;

    public User() {
    }

    public User(String name, String school, String nickName) {
        this.name = name;
        this.school = school;
        this.nickName = nickName;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
