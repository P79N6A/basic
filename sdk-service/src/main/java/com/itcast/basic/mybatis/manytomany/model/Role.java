package com.itcast.basic.mybatis.manytomany.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by treey.qian on 2018/1/22.
 */
public class Role implements Serializable {
    private long id;
    private String roleName;
    private String note;
    private long userId;
    private List<User> userList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                ", userId=" + userId +
                ", userList=" + userList +
                '}';
    }
}
