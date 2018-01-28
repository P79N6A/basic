package com.itcast.basic.spring.config.aop.dynamic.simpleadvisors;

/**
 * Created by qfl on 16/7/30.
 */
public class ServiceImp implements ServiceInterface {
    @Override
    public void save() {
        System.out.println("保存数据");
    }

    @Override
    public void update() {
        System.out.println("更新数据");
    }

    @Override
    public void delete() {
        System.out.println("删除数据");
    }
}
