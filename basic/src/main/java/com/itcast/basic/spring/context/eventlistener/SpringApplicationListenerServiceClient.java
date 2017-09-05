package com.itcast.basic.spring.context.eventlistener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/9/5.
 */
public class SpringApplicationListenerServiceClient {

    private static final Log log = LogFactory.getLog(SpringApplicationListenerServiceClient.class);

    public static void main(String[] args) {
        try {
            log.info("enter SpringPropertyConfigurerServiceClient");
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/eventlistener/application.xml"});
            InvokeEventPublishProxy invokeEventPublishProxy = (InvokeEventPublishProxy) classPathXmlApplicationContext.getBean("invokeEventPublishProxy");
            invokeEventPublishProxy.sysMessage("hello world");
        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }
}
