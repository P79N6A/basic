package com.itcast.basic.designpatterntype.mediator.nomediator;

/**
 * Created by qfl on 16/6/4.
 */
public class UserA {
    private UserB userB;

    public UserA(UserB userB) {
        this.userB = userB;
    }

    public UserB getUserB() {
        return userB;
    }

    public void setUserB(UserB userB) {
        this.userB = userB;
    }

    public void initUserB() {
        System.out.println("初始化UserB");
        userB.init();
    }

    public void deleteUserBData() {
        System.out.println("删除UserB中的数据");
        userB.delete();
    }

    public void addData() {
        System.out.println("UserA中数据增加中.....");
    }

}
