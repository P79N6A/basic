package com.itcast.basic.spring.context.il8nconfigure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by treey.qian on 2017/9/4.
 */
public class SpringIl8nConfigurerServiceClient {

    private static final Log log = LogFactory.getLog(SpringIl8nConfigurerServiceClient.class);


    public static void main(String[] args) {
        try {
            log.info("enter SpringPropertyConfigurerServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/il8nconfigure/application.xml"});
            String name = applicationContext.getMessage("name", null, Locale.ENGLISH);
            log.info("name=" + name);
        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }
}
