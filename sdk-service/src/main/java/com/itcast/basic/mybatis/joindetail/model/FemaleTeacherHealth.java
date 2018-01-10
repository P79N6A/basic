package com.itcast.basic.mybatis.joindetail.model;

/**
 * Created by treey.qian on 2018/1/10.
 */
public class FemaleTeacherHealth extends TeacherHealth {

    private String breastDesc;
    private String uterusDesc;

    public FemaleTeacherHealth() {
    }

    public FemaleTeacherHealth(long teacherId, String liverDesc, String lungDesc, String spleenDesc, String heartDesc, String breastDesc, String uterusDesc) {
        super(teacherId, liverDesc, lungDesc, spleenDesc, heartDesc);
        this.breastDesc = breastDesc;
        this.uterusDesc = uterusDesc;
    }

    public String getBreastDesc() {
        return breastDesc;
    }

    public void setBreastDesc(String breastDesc) {
        this.breastDesc = breastDesc;
    }

    public String getUterusDesc() {
        return uterusDesc;
    }

    public void setUterusDesc(String uterusDesc) {
        this.uterusDesc = uterusDesc;
    }

    @Override
    public String toString() {
        return "FemaleTeacherHealth{" +
                super.toString() +
                "breastDesc='" + breastDesc + '\'' +
                ", uterusDesc='" + uterusDesc + '\'' +
                '}';
    }
}
