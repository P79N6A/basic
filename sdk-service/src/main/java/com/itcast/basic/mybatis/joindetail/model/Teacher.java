package com.itcast.basic.mybatis.joindetail.model;

import java.util.List;

/**
 * Created by treey.qian on 2018/1/10.
 */
public class Teacher {
    private long id;
    private String name;
    private Sex sex;
    private String schoolName;

    private List<Lesson> lessons;
    private TeacherCard teacherCard;
    private TeacherHealth teacherHealth;

    public Teacher() {
    }

    public Teacher(String name, Sex sex, String schoolName) {
        this.name = name;
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

    public TeacherCard getTeacherCard() {
        return teacherCard;
    }

    public void setTeacherCard(TeacherCard teacherCard) {
        this.teacherCard = teacherCard;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public TeacherHealth getTeacherHealth() {
        return teacherHealth;
    }

    public void setTeacherHealth(TeacherHealth teacherHealth) {
        this.teacherHealth = teacherHealth;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (lessons != null && !lessons.isEmpty()) {
            stringBuilder.append("[");
            for (Lesson lesson : lessons) {
                stringBuilder.append(lesson.toString()).append(" ");
            }
            stringBuilder.append("]");
        }

        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", schoolName='" + schoolName + '\'' +
                ", lessons=" + stringBuilder.toString() +
                ", teacherCard=" + teacherCard +
                ", teacherHealth=" + teacherHealth +
                '}';
    }
}
