package com.itcast.basic.spring.aop.annotation.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by treey.qian on 2017/10/16.
 */
@Component
@Aspect
public class AspectAdvisorService {

    private final Log log = LogFactory.getLog(AspectAdvisorService.class);

    /**
     * 声明一个切面
     */
    @Pointcut("execution(* com.itcast.basic.spring.aop.annotation.service..*.*(..))")
    private void anyMethod() {

    }

    @Pointcut("execution(* com.itcast.basic.spring.aop.annotation.service..*.save*(..))")
    private void saveMethod() {

    }

    @Around("anyMethod()")
    public void logger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("insert system execution begin time");
        proceedingJoinPoint.proceed();
        log.info("insert system execution end time");
    }

    @Before("saveMethod()")
    public void clearCache() {
        log.info("execute clear redis");
    }

    @After("saveMethod()&&args(name)")
    public void initSession(String name) {
        log.info("save data,flag is " + name);
    }

    @AfterReturning("saveMethod()")
    public void createCache() {
        log.info("execute create cachedetail");
    }
}
