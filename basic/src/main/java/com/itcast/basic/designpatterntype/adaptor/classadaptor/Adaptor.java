package com.itcast.basic.designpatterntype.adaptor.classadaptor;

/**
 * Created by qfl on 16/6/3.
 */
public class Adaptor extends SubjectD implements SubjectC {
    @Override
    public void operateCoreC() {
        System.out.println("对C进行相关操作");
    }

    @Override
    void operateD() {
        System.out.println("对D进行相关操作");
    }
}
