package com.itcast.basic.spring.aop.aspect.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

/**
 * Created by treey.qian on 2017/10/16.
 */
@Service
public class LoggerSevice {

    private final Log log = LogFactory.getLog(LoggerSevice.class);

    public void logger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("insert into log begin");
        if (proceedingJoinPoint != null) {
            proceedingJoinPoint.proceed();
            Object target = proceedingJoinPoint.getTarget();
            if (target != null) {
                log.info("execute " + target.getClass().getName() + " method");
            }
        } else {
            log.info("proceedingJoinPoint is null");
        }
        log.info("insert into log end");
    }

    public void sysLog() {
        log.info("insert into sysLog end");
    }
}
