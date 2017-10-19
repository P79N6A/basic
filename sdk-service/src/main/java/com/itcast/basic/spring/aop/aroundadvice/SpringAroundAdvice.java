package com.itcast.basic.spring.aop.aroundadvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class SpringAroundAdvice implements MethodInterceptor {
    private final Log logger = LogFactory.getLog(SpringAroundAdvice.class);

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        logger.info("before invoke method, name is " + methodInvocation.getMethod().getName());
        methodInvocation.proceed();
        logger.info("after invoke method, name is " + methodInvocation.getMethod().getName());
        return null;
    }
}
