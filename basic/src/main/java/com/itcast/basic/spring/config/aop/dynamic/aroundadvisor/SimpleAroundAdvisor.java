package com.itcast.basic.spring.config.aop.dynamic.aroundadvisor;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by qfl on 16/7/30.
 */
public class SimpleAroundAdvisor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("打开session");
        Object object = invocation.proceed();
        System.out.println("关闭session");
        return object;
    }
}
