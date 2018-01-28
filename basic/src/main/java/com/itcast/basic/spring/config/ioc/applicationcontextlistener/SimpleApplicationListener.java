package com.itcast.basic.spring.config.ioc.applicationcontextlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by qfl on 16/7/28.
 */
public class SimpleApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof SimpleApplicationEvent) {
            SimpleApplicationEvent simpleApplicationEvent = (SimpleApplicationEvent) event;
            System.out.println(simpleApplicationEvent.toString());
        }
    }
}
