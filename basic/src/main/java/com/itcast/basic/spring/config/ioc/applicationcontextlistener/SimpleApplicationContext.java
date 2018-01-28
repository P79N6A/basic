package com.itcast.basic.spring.config.ioc.applicationcontextlistener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by qfl on 16/7/29.
 */
public class SimpleApplicationContext implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void sysHell() {
        this.applicationContext.publishEvent(new SimpleApplicationEvent("hello", "lily", "1258166167@qq.com", "这是一个邮件发送系统"));
    }
}
