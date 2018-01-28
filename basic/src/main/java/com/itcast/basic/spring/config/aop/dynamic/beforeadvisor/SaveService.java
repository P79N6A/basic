package com.itcast.basic.spring.config.aop.dynamic.beforeadvisor;

/**
 * Created by qfl on 16/7/30.
 */
public class SaveService implements ServiceInterface {
    @Override
    public void save() {
        System.out.println("正在进行保存操作");
    }
}
