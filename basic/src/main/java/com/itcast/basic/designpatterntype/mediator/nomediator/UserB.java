package com.itcast.basic.designpatterntype.mediator.nomediator;

/*
*
* Created by qfl on 16/6/4.
*/

public class UserB {
    private UserA userA;

    public UserB(UserA userA) {
        this.userA = userA;
    }

    public void init() {
        System.out.println("UserB初始化进行中.....");
    }

    public void delete() {
        System.out.println("UserB数据删除中......");
    }

    public void addUserAData() {
        System.out.println("请求增加UserA中的数据");
        userA.addData();
    }
}
