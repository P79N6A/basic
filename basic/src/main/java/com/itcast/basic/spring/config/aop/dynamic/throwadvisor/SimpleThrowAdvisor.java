package com.itcast.basic.spring.config.aop.dynamic.throwadvisor;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by qfl on 16/7/30.
 */
public class SimpleThrowAdvisor implements ThrowsAdvice {

    public void afterThrowing(Method m, Object args, Object target,
                              Throwable subclass) {
        System.out.println("[DaoThrowsAdvice]: An exception occur: "
                + subclass.getClass().getSimpleName());
        System.exit(0);
    }
}