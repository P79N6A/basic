package com.itcast.basic.jdk.cloneable;

/**
 * Created by Administrator on 2018/2/3.
 */
public class School implements Cloneable {
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "School{" +
                "school='" + school + '\'' +
                '}';
    }
}
