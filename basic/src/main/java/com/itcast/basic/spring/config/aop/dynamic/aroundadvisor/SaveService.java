package com.itcast.basic.spring.config.aop.dynamic.aroundadvisor;

/**
 * Created by qfl on 16/7/30.
 */
public class SaveService implements ServiceInterface {
    @Override
    public Object save() {
        System.out.println("保存数据");
        return "sucess";
    }
}
