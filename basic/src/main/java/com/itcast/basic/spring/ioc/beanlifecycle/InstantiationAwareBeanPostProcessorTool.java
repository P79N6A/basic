package com.itcast.basic.spring.ioc.beanlifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created by treey.qian on 2017/8/29.
 */
public class InstantiationAwareBeanPostProcessorTool extends InstantiationAwareBeanPostProcessorAdapter {

    private final Log log= LogFactory.getLog(InstantiationAwareBeanPostProcessorAdapter.class);

    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        log.info("enter InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation");
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log.info("enter InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInstantiation");
        return true;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        log.info("enter InstantiationAwareBeanPostProcessorAdapter.postProcessPropertyValues");
        return pvs;
    }
}
