package com.itcast.basic.spring.aop.annotation;

import com.itcast.basic.spring.aop.annotation.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/16.
 */
public class SpringAspectServiceClient {

    private static final Log logger = LogFactory.getLog(SpringAspectServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringAspectServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/aop/annotation/application.xml"});
            PersonService personService = (PersonService) applicationContext.getBean("personService");
            personService.savePerson("admin");
        } catch (Exception e) {
            logger.info("error is {}", e);
        }
    }

}
