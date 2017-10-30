package com.itcast.basic.spring.rmi.hessian.client;

import com.itcast.basic.spring.rmi.api.Person;
import com.itcast.basic.spring.rmi.api.SavePerson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/10/30.
 */
public class HessianSpringServiceClientMain {

    private static final Log logger = LogFactory.getLog(HessianSpringServiceClientMain.class);

    public static void main(String[] args) {
        try {
            logger.info("enter into HessianSpringServiceClientMain");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/rmi/hessian/client/application.xml"});
            SavePerson savePersonProxy=(SavePerson)applicationContext.getBean("savePersonProxy");
            savePersonProxy.save(new Person("Lily","wuhan"));
        } catch (Exception e) {
            logger.info("HessianSpringServiceClientMain error message is {}", e);
        }
    }
}
