package com.itcast.basic.spring.ioc.bean.inherit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/8/30.
 */
public class SpringBeanInheritServiceClient {

    private static final Log log = LogFactory.getLog(SpringBeanInheritServiceClient.class);

    public static void main(String[] args) {
        try {
            log.info("SpringBeanInheritServiceClient");
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/bean/inherit/application.xml"});
            Person student = (Person) classPathXmlApplicationContext.getBean("student");
            Person person = (Person) classPathXmlApplicationContext.getBean("person");
            log.info("student=" + student + " person=" + person);
        } catch (Exception e) {
            log.info("error is {}", e);
        }

    }


}
