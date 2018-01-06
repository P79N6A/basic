package com.itcast.basic.spring.aop.afteradvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class SpringAfterAdvice implements AfterReturningAdvice {
    private final Log logger = LogFactory.getLog(SpringAfterAdvice.class);

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        logger.info("invoke " + method.getName() + " finish");
    }
}
