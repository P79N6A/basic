package com.itcast.basic.mybatis.tool.splitpage.pagingplugin.model;

import java.io.Serializable;

/**
 * Created by treey.qian on 2018/1/22.
 */
public class User implements Serializable {

    private long id;
    private String name;
    private String nickName;
    private String school;
    private String note;
    private long roleId;


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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", school='" + school + '\'' +
                ", note='" + note + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
