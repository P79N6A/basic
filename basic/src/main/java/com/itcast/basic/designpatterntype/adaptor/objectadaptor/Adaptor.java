package com.itcast.basic.designpatterntype.adaptor.objectadaptor;

/**
 * Created by qfl on 16/6/3.
 */
public class Adaptor extends SubjectE {
    private SubjectF subjectF;

    public Adaptor(SubjectF subjectF) {
        this.subjectF = subjectF;
    }

    @Override
    public void operateE() {
        System.out.println("对E进行相关操作");
    }

    public void operateF() {
        this.subjectF.operateF();
    }
}
