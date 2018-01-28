package com.itcast.basic.spring.config.aop.dynamic.throwadvisor;

/**
 * Created by qfl on 16/7/30.
 */
public class SaveService implements ServiceInterface {
    @Override
    public void save() {
        int i = 2 / 0;
        System.out.println("正在进行保存操作");
    }
}
