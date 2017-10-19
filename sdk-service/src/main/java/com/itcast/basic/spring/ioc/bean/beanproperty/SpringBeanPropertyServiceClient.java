package com.itcast.basic.spring.ioc.bean.beanproperty;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/8/30.
 */
public class SpringBeanPropertyServiceClient {
    private static final Log log = LogFactory.getLog(SpringBeanPropertyServiceClient.class);

    public static void main(String[] args) {
        try {
            log.info("SpringBeanPropertyServiceClient");
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/bean/beanproperty/application.xml"});
            BeanBasicProperty beanBasicProperty = (BeanBasicProperty) classPathXmlApplicationContext.getBean("beanBasicProperty");
            log.info("beanBasicProperty=" + beanBasicProperty);
        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }
}
