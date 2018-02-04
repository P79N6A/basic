package com.itcast.basic.jdk.keywords.scope.model;

/**
 * Created by treey.qian on 2018/1/29.
 */
public class Parent {

    public Parent() {
        Human human = new Human();
        //同包下访问保护域
        System.out.println("nickName is " + human.nickName);

        //同包下访问默认域
        System.out.println("schoolName is " + human.schoolName);
    }
}
