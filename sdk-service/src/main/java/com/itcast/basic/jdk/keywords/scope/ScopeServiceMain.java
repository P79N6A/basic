package com.itcast.basic.jdk.keywords.scope;

/**
 * Created by Administrator on 2018/1/30.
 */
public class ScopeServiceMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into ScopeServiceMain");
            FunctionnalInterface.sys();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
