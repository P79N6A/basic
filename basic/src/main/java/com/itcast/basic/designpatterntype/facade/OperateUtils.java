package com.itcast.basic.designpatterntype.facade;

/**
 * Created by qfl on 16/6/3.
 */
public class OperateUtils {
    public static void connect() {
        System.out.println("连接数据库");
    }

    public static void operate() {
        System.out.println("进行核心操作");
    }

    public static void close() {
        System.out.println("关闭数据库");
    }
}
