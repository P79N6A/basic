package com.itcast.basic.web.vo;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/10/31.
 */
public class UserInfoVO implements Serializable {

    private int id;
    private String name;
    private String school;

    public UserInfoVO() {
    }

    public UserInfoVO(int id, String name, String school) {
        this.id = id;
        this.name = name;
        this.school = school;
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

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
