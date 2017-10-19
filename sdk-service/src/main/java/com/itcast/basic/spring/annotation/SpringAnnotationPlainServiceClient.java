package com.itcast.basic.spring.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/8/31.
 */
public class SpringAnnotationPlainServiceClient {
    private static final Log log = LogFactory.getLog(SpringAnnotationPlainServiceClient.class);

    public static void main(String[] args) {
        try {
            log.info("SpringBeanPropertyServiceClient");
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/annotation/application.xml"});

        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }
}
