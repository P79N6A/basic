package com.itcast.basic.designpatterntype.templte;

/**
 * Created by qfl on 16/6/3.
 */
public class OperateDB extends Templte {
    @Override
    public void init() {
        System.out.println("连接DB数据库");
    }

    @Override
    public void operate() {
        System.out.println("进行DB数据库的增删改查操作");
    }

    @Override
    public void close() {
        System.out.println("关闭DB数据库");
    }
}
