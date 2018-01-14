package com.itcast.basic.mybatis.joindetail.model;

/**
 * Created by treey.qian on 2018/1/10.
 */
public class Lesson {
    private long id;
    private long teacherId;
    private String lesName;
    private String note;

    public Lesson() {
    }

    public Lesson(long teacherId, String lesName, String note) {
        this.teacherId = teacherId;
        this.lesName = lesName;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getLesName() {
        return lesName;
    }

    public void setLesName(String lesName) {
        this.lesName = lesName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", lesName='" + lesName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
