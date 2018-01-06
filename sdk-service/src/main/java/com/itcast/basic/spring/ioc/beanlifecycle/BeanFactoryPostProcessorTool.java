package com.itcast.basic.spring.ioc.beanlifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by treey.qian on 2017/8/29.
 */
public class BeanFactoryPostProcessorTool implements BeanFactoryPostProcessor {

    private final Log log= LogFactory.getLog(BeanFactoryPostProcessorTool.class);

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("enter BeanFactoryPostProcessor.postProcessBeanFactory");
    }
}
