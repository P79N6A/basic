package com.itcast.basic.designpatterntype.templte;

/**
 * Created by qfl on 16/6/3.
 */
public class OperateOracle extends Templte {
    @Override
    public void init() {
        System.out.println("连接oracle数据库");
    }

    @Override
    public void operate() {
        System.out.println("进行oracle数据库的增删改查操作");
    }

    @Override
    public void close() {
        System.out.println("关闭oracle数据库");
    }
}
