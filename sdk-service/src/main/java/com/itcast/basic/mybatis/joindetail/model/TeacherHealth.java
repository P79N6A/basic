package com.itcast.basic.mybatis.joindetail.model;

/**
 * Created by treey.qian on 2018/1/10.
 */
public class TeacherHealth {

    private long id;
    private long teacherId;
    private String liverDesc;
    private String lungDesc;
    private String spleenDesc;
    private String heartDesc;

    public TeacherHealth() {
    }

    public TeacherHealth(long teacherId, String liverDesc, String lungDesc, String spleenDesc, String heartDesc) {
        this.teacherId = teacherId;
        this.liverDesc = liverDesc;
        this.lungDesc = lungDesc;
        this.spleenDesc = spleenDesc;
        this.heartDesc = heartDesc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLiverDesc() {
        return liverDesc;
    }

    public void setLiverDesc(String liverDesc) {
        this.liverDesc = liverDesc;
    }

    public String getLungDesc() {
        return lungDesc;
    }

    public void setLungDesc(String lungDesc) {
        this.lungDesc = lungDesc;
    }

    public String getSpleenDesc() {
        return spleenDesc;
    }

    public void setSpleenDesc(String spleenDesc) {
        this.spleenDesc = spleenDesc;
    }

    public String getHeartDesc() {
        return heartDesc;
    }

    public void setHeartDesc(String heartDesc) {
        this.heartDesc = heartDesc;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", teacherId=" + teacherId +
                ", liverDesc='" + liverDesc + '\'' +
                ", lungDesc='" + lungDesc + '\'' +
                ", spleenDesc='" + spleenDesc + '\'' +
                ", heartDesc='" + heartDesc + '\'';
    }
}
