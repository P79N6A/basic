package com.itcast.basic.designpatterntype.mediator.mediator;

/**
 * Created by qfl on 16/6/4.
 */
public class UserUtils {
    private UserA userA;
    private UserB userB;

    public UserUtils(UserA userA, UserB userB) {
        this.userA = userA;
        this.userB = userB;
    }

    public UserUtils() {
    }

    public UserA getUserA() {
        return userA;
    }

    public void setUserA(UserA userA) {
        this.userA = userA;
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

    public void init() {
        System.out.println("UserB初始化进行中.....");
    }

    public void delete() {
        System.out.println("UserB数据删除中......");
    }
}
