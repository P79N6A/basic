package com.itcast.basic.spring.rmi.spring.client;

import com.itcast.basic.spring.rmi.api.Person;
import com.itcast.basic.spring.rmi.api.SavePerson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/30.
 */
public class RmiSpringServiceClientMain {

    private static final Log logger = LogFactory.getLog(RmiSpringServiceClientMain.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into RmiSpringServiceClientMain");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/rmi/spring/client/application.xml"});
            SavePerson savePersonProxy=(SavePerson)applicationContext.getBean("savePersonProxy");
            savePersonProxy.save(new Person("Lily","wuhan"));
        } catch (Exception e) {
            logger.info("RmiSpringServiceClientMain error message is {}", e);
        }
    }
}
