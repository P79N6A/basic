package com.itcast.basic.mybatis.dynamicsqldetail.model;

/**
 * Created by Administrator on 2018/1/14.
 */
public class UserParams {

    private long id;
    private String name;
    private String school;
    private String nickName;

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
        return "UserParams{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
