package com.itcast.basic.spring.config.ioc.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by qfl on 16/7/28.
 */
public class BeanInitProcessor implements BeanFactoryAware, BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactoryAware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("beanNameAware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContextAware");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initializingbean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("disposableAware");
    }

    public void init() {
        System.out.println("init method");
    }

    public void close() {
        System.out.println("destory method");
    }

    public void sysHello() {
        System.out.println("hello world, i am Lily");
    }
}
