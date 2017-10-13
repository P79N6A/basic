package com.itcast.basic.spring.aop.throwadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by treey.qian on 2017/10/13.
 */
public class SpringThrowAdvice implements ThrowsAdvice {
    private final Log logger = LogFactory.getLog(SpringThrowAdvice.class);

    //ThrowsAdvice接口没有声明任何方法 虚拟机在运行时会自动调用afterThrowing桥方法
    public void afterThrowing(Method method, Object args, Object target,
                              Throwable subclass) {
        logger.info("invoke method exception,exception class is " + subclass.getClass().getName());
    }
}
