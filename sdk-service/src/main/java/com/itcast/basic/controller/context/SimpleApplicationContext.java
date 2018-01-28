package com.itcast.basic.controller.context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by Administrator on 2018/1/27.
 */
public class SimpleApplicationContext implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {
    private static Log logger = LogFactory.getLog(SimpleApplicationContext.class);

    private ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("=====================================spring容易初始化完毕================================================");
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            logger.info("***************spring 容器初始化完毕 可以进行应用初始化操作**********************");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        logger.info("*****************这里可以获得spring容器*************************************");
    }
}
