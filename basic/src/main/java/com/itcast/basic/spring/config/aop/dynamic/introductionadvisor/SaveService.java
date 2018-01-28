package com.itcast.basic.spring.config.aop.dynamic.introductionadvisor;

/**
 * Created by qfl on 16/7/30.
 */
public class SaveService implements ServiceInterface {
    @Override
    public void save() {
        System.out.println("正在进行保存操作");
    }

    @Override
    public void update() {
        System.out.println("正在进行更新操作");
    }

    @Override
    public void query() {
        System.out.println("正在进行查询操作");
    }

    @Override
    public void delete() {
        System.out.println("正在进行删除操作");
    }

}
