package com.itcast.basic.jdk.keywords.scope;

import com.itcast.basic.jdk.keywords.scope.model.Human;

/**
 * Created by treey.qian on 2018/1/29.
 */
public class Person extends Human {

    public Person() {
        //不同包下子类访问保护域
        System.out.println("nickName is " + this.nickName);
    }
}
