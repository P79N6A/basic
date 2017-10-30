package com.itcast.basic.spring.rmi.burlap.client;

import com.itcast.basic.spring.rmi.api.Person;
import com.itcast.basic.spring.rmi.api.SavePerson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/30.
 */
public class BurlapSpringServiceClientMain {

    private static final Log logger = LogFactory.getLog(BurlapSpringServiceClientMain.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into BurlapSpringServiceClientMain");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/rmi/hessian/client/application.xml"});
            SavePerson burlapServiceExporter=(SavePerson)applicationContext.getBean("burlapServiceExporter");
            burlapServiceExporter.save(new Person("Lily","wuhan"));
        } catch (Exception e) {
            logger.info("BurlapSpringServiceClientMain error message is {}", e);
        }
    }
}
