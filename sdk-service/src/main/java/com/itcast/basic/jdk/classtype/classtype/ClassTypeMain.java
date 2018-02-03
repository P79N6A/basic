package com.itcast.basic.jdk.classtype.classtype;

/**
 * Created by Administrator on 2018/2/3.
 */
public class ClassTypeMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into ClassTypeMain");
            OutterObject.sysInnerName();
            OutterObject.InnerObject0 innerObject0 = new OutterObject().new InnerObject0();
            OutterObject.InnerObject innerObject = new OutterObject.InnerObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
