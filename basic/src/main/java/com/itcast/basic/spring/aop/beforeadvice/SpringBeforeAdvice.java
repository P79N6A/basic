package com.itcast.basic.spring.aop.beforeadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class SpringBeforeAdvice implements MethodBeforeAdvice {

    private final Log logger = LogFactory.getLog(SpringBeforeAdvice.class);

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        try {
            logger.info("exe check data");
        } catch (Exception e) {
            logger.info("SpringBeforeAdvice error message is {}", e);
        }
    }
}
