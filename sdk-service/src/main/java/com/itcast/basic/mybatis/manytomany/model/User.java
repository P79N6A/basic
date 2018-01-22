package com.itcast.basic.mybatis.manytomany.model;

import java.io.Serializable;
import java.util.List;

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
    private List<Role> roleList;


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

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
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
                ", roleList=" + roleList +
                '}';
    }
}
