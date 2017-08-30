package com.itcast.basic.spring.ioc.beanlifecycle;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/8/25.
 */
public class SpringBeanLifecycleServiceClient {

    private static final Log log = LogFactory.getLog(SpringBeanLifecycleServiceClient.class);

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/bean/application.xml");
            PlainOldBean plainOldBean = (PlainOldBean) classPathXmlApplicationContext.getBean("plainOldBean");
            log.info("name is " + plainOldBean.getName());
            classPathXmlApplicationContext.registerShutdownHook();
        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }
}
