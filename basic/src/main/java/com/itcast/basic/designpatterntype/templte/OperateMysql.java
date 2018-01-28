package com.itcast.basic.designpatterntype.templte;

/**
 * Created by qfl on 16/6/3.
 */
public class OperateMysql extends Templte {
    @Override
    public void init() {
        System.out.println("连接mysql数据库");
    }

    @Override
    public void operate() {
        System.out.println("进行mysql数据库的增删改查操作");
    }

    @Override
    public void close() {
        System.out.println("关闭mysql数据库");
    }
}
