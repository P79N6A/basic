package com.itcast.basic.spring.aop.instroductionadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class SpringBeforeAdvice implements MethodBeforeAdvice {

    private final Log log = LogFactory.getLog(SpringBeforeAdvice.class);

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.info("check data ready");
    }
}
