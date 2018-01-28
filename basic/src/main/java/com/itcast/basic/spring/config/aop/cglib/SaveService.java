package com.itcast.basic.spring.config.aop.cglib;

/**
 * Created by qfl on 16/7/30.
 */
public class SaveService {
    public void save() {
        System.out.println("保存数据");
    }

    public void query() {
        System.out.println("查询数据");
    }

    public void update() {
        System.out.println("修改数据");
    }

    public void delete() {
        System.out.println("删除数据");
    }

}
