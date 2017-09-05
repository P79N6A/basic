package com.itcast.basic.spring.context.eventlistener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Date;

/**
 * Created by treey.qian on 2017/9/5.
 */
public class InvokeEventPublishProxy implements ApplicationContextAware {

    private final Log log = LogFactory.getLog(InvokeEventPublishProxy.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void sysMessage(Object message) {

        if (message == null) {
            applicationContext.publishEvent(new InvokeEvent("invokeEventPublishProxy instance invoke", "invokeEventPublishProxy fail", new Date(), "sysMessage"));
        } else {
            applicationContext.publishEvent(new InvokeEvent("invokeEventPublishProxy instance invoke", "invokeEventPublishProxy success", new Date(), "sysMessage"));
            log.info("receive message is " + message.toString());
        }

    }

}
