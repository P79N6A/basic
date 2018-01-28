package com.itcast.basic.spring.config.aop.dynamic.simpleadvisors;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by qfl on 16/7/30.
 */
public class SimpleMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("执行环绕通知前段");
        Object object = methodInvocation.proceed();
        System.out.println("执行环绕通知后段");
        return object;
    }
}
