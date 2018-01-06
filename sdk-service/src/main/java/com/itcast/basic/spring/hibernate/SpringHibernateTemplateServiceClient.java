package com.itcast.basic.spring.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

/**
 * Created by treey.qian on 2017/10/19.
 */
public class SpringHibernateTemplateServiceClient {
    private static final Log logger = LogFactory.getLog(SpringHibernateTemplateServiceClient.class);
    private static HibernateTemplate hibernateTemplate;

    public static void main(String[] args) {
        try {
            logger.info("enter into SpringHibernateTemplateServiceClient");
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/hibernate/application.xml"});
            hibernateTemplate = (HibernateTemplate) applicationContext.getBean("hibernateTemplate");
            query();
        } catch (Exception e) {
            logger.info("springHibernateTemplateServiceClient error message is {}", e);
        }
    }

    private static Session inintSession() {
        return hibernateTemplate.getSessionFactory().openSession();
    }

    private static void query() {
        List<Student> students = (List<Student>) hibernateTemplate.execute(new StudentCallback());
        for (Student student : students) {
            logger.info("student = " + student);
        }
    }
}
