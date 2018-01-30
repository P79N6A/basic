package com.itcast.basic.jdk.keywords.scope;

import com.itcast.basic.jdk.keywords.scope.model.Human;

/**
 * Created by treey.qian on 2018/1/29.
 */
public class Children {

    public Children() {
        Human human = new Human();
        //不同包类访问不到保护域
//        System.out.println("nickName is " + human.nickName);

        //不同包类访问不到默认域
//        System.out.println("schoolName is " + human.schoolName);
    }

}
