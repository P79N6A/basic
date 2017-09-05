package com.itcast.basic.spring.context.eventlistener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by treey.qian on 2017/9/5.
 */
public class ApplicationEventListenerProxy implements ApplicationListener {

    private final Log log = LogFactory.getLog(ApplicationEventListenerProxy.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof InvokeEvent) {
            log.info("receive invoke event,details is {}" + event.toString());
        }
    }
}
