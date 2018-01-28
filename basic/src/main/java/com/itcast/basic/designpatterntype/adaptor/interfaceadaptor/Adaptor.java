package com.itcast.basic.designpatterntype.adaptor.interfaceadaptor;

/**
 * Created by qfl on 16/6/3.
 */
public class Adaptor implements SubjectA, SubjectB {
    @Override
    public void operateCoreA() {
        System.out.println("对A进行相关操作");
    }


    @Override
    public void operateCoreB() {
        System.out.println("对B进行相关操作");
    }
}
