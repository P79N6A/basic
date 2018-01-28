package com.itcast.basic.webservice.entity;

import com.sdk.model.Sex;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by treey.qian on 2018/1/8.
 */
public class User implements Serializable{

    //序列号
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String nickName;
    private Sex sex;
    private String schoolName;
    private Date createTime;
    private Date updateTime;

    public User() {
    }

    public User(String name, String nickName, Sex sex, String schoolName) {
        this.name = name;
        this.nickName = nickName;
        this.sex = sex;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", schoolName='" + schoolName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
