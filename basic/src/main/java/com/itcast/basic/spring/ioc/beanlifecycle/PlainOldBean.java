package com.itcast.basic.spring.ioc.beanlifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by treey.qian on 2017/8/28.
 */
public class PlainOldBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private final Log log = LogFactory.getLog(PlainOldBean.class);

    private String name;

    public PlainOldBean() {
        log.info("enter PlainOldBean");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        log.info("enter setName");
        this.name = name;
    }

    public void setBeanName(String name) {
        log.info("enter setBeanName");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("enter setBeanFactory");
    }

    public void afterPropertiesSet() throws Exception {
        log.info("enter afterPropertiesSet");
    }

    public void destroy() throws Exception {
        log.info("enter destroy");
    }

    public void initMethod() {
        log.info("enter initMethod");
    }

    public void destroyMethod() {
        log.info("enter destroyMethod");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("enter ApplicationContextAware.setApplicationContext");
    }
}
