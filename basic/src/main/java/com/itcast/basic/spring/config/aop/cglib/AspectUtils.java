package com.itcast.basic.spring.config.aop.cglib;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by qfl on 16/7/30.
 */
public class AspectUtils {

    public void openSession(JoinPoint joinpoint) {
        System.out.println("开启session");
    }

    public Object beginTraction(JoinPoint joinpoint, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("开启事务");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("写入sql执行计划");
        return object;
    }

    public void commit(JoinPoint joinpoint) {
        System.out.println("提交事务");
    }

    public void occurThrow(JoinPoint joinpoint) {
        System.out.println("发生异常");
    }

    public void close(JoinPoint joinpoint) {
        System.out.println("关闭session");
    }
}
