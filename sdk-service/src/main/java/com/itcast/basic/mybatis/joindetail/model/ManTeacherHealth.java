package com.itcast.basic.mybatis.joindetail.model;

/**
 * Created by treey.qian on 2018/1/10.
 */
public class ManTeacherHealth extends TeacherHealth {

    private String prostateDesc;
    private String testisDesc;

    public ManTeacherHealth() {
    }

    public ManTeacherHealth(long teacherId, String liverDesc, String lungDesc, String spleenDesc, String heartDesc, String prostateDesc, String testisDesc) {
        super(teacherId, liverDesc, lungDesc, spleenDesc, heartDesc);
        this.prostateDesc = prostateDesc;
        this.testisDesc = testisDesc;
    }

    public String getProstateDesc() {
        return prostateDesc;
    }

    public void setProstateDesc(String prostateDesc) {
        this.prostateDesc = prostateDesc;
    }

    public String getTestisDesc() {
        return testisDesc;
    }

    public void setTestisDesc(String testisDesc) {
        this.testisDesc = testisDesc;
    }

    @Override
    public String toString() {
        return "ManTeacherHealth{" +
                super.toString() +
                "prostateDesc='" + prostateDesc + '\'' +
                ", testisDesc='" + testisDesc + '\'' +
                '}';
    }
}
