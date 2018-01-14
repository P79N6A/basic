package com.itcast.basic.mybatis.joindetail.model;

/**
 * Created by treey.qian on 2018/1/10.
 */
public class TeacherCard {
    private long id;
    private String number;
    private String address;
    private String note;
    private long teacherId;

    public TeacherCard() {
    }

    public TeacherCard(String number, String address, String note, long teacherId) {
        this.number = number;
        this.address = address;
        this.note = note;
        this.teacherId = teacherId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "TeacherCard{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", note='" + note + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }
}
