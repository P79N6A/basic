package com.itcast.basic.spring.autowrite;

import com.itcast.basic.spring.autowrite.service.PersonServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/11/22.
 */
public class AutoWriteServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into AutoWriteServiceClient");
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/autowrite/application.xml"});
            PersonServiceImpl personService = (PersonServiceImpl) classPathXmlApplicationContext.getBean("personService");
            personService.savePerson();
        } catch (Exception e) {
            System.out.println("error message is " + e);
        }
    }
}
