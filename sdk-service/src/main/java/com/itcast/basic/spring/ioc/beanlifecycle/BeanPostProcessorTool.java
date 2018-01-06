package com.itcast.basic.spring.ioc.beanlifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by treey.qian on 2017/8/29.
 */
public class BeanPostProcessorTool implements BeanPostProcessor {
    private final Log log = LogFactory.getLog(BeanPostProcessorTool.class);

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("enter BeanPostProcessor.postProcessBeforeInitialization");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("enter BeanPostProcessor.postProcessAfterInitialization");
        return bean;
    }
}
