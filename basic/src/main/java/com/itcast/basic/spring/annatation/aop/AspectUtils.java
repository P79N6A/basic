package com.itcast.basic.spring.annatation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by qfl on 16/7/31.
 */
@Component
@Aspect
public class AspectUtils {

    @Pointcut("execution(* com.itcast.basic.spring.annatation.aop.SaveService.*(..))")
    private void anyMethod() {

    }

    @Before("anyMethod() && args(name)")
    public void initSession(String name) {
        System.out.println("执行前置通知"+name);
    }

    @After("anyMethod()")
    public void beginTranction() {
        System.out.println("执行后置通知");
    }

    @Around("anyMethod()")
    public Object exceSQL(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("执行环绕通知的前置动作");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("执行环绕通知的后置动作");
        return object;
    }

    @AfterReturning("anyMethod()")
    public void close() {
        System.out.println("函数正常返回后,执行后置通知");
    }

    @AfterThrowing("anyMethod()")
    public void exit() {
        System.out.println("用异常,即将退出");
        System.exit(0);
    }


}
