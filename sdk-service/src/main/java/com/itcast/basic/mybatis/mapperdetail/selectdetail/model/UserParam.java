package com.itcast.basic.mybatis.mapperdetail.selectdetail.model;

/**
 * Created by treey.qian on 2018/1/9.
 */
public class UserParam {
    private String name;
    private String school;

    public UserParam() {
    }

    public UserParam(String name, String school) {
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
}
