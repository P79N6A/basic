package com.itcast.basic.spring.aop.aspect;

import com.itcast.basic.spring.aop.aspect.service.MessageService;
import com.itcast.basic.spring.aop.aspect.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/16.
 */
public class SpringAspectServiceClient {

    private static Log logger = LogFactory.getLog(SpringAspectServiceClient.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringAspectServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/aop/aspect/application.xml"});
            PersonService personService = (PersonService) applicationContext.getBean("personService");
            personService.createPerson();
            personService.findPerson();
            MessageService messageService = (MessageService) applicationContext.getBean("messageService");
            messageService.createMessage();
            messageService.findMessage();
            messageService.deleteMessage();
        } catch (Exception e) {
            logger.info("error is {}", e);
        }
    }
}
