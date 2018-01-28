package com.itcast.basic.spring.config.aop.dynamic.beforeadvisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by qfl on 16/7/30.
 */
public class SimpleBeforeAdvisor implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("正在开启事务");
    }
}
