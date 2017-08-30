package com.itcast.basic.spring.ioc.dependencyinjection;

import com.itcast.basic.spring.ioc.dependencyinjection.constructor.Student;
import com.itcast.basic.spring.ioc.dependencyinjection.injector.Teacher;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by treey.qian on 2017/8/30.
 */
public class SpringDependencyInjectionServiceClient {

    private static Log log = LogFactory.getLog(SpringDependencyInjectionServiceClient.class);

    public static void main(String[] args) {
        initConstructorWay();
        initInjectorWay();
        staticFactoryMethod();
        factoryMethod();
    }

    /**
     * 实例工厂方法初始化spring bean
     */
    private static void factoryMethod() {
        try {
            log.info("enter SpringDependencyInjectionServiceClient.factoryMethod");
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dependencyinjection/factorymethod/application.xml"});
            Money money = (Money) classPathXmlApplicationContext.getBean("money");
            log.info("money=" + money);
        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }

    /**
     * 静态工厂方法实例化spring bean
     */
    private static void staticFactoryMethod() {
        try {
            log.info("enter SpringDependencyInjectionServiceClient.staticFactoryMethod");
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dependencyinjection/staticfactorymethod/application.xml"});
            Money money = (Money) classPathXmlApplicationContext.getBean("money");
            log.info("money=" + money);

        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }

    /**
     * 构造器注入方式
     */
    private static void initConstructorWay() {
        try {
            log.info("enter SpringDependencyInjectionServiceClient.initConstructorWay");
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dependencyinjection/constructor/application.xml"});
            Student student = (Student) classPathXmlApplicationContext.getBean("student");
            log.info("student=" + student);

        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }

    /**
     * setter注册器注入方式
     */
    private static void initInjectorWay() {
        try {
            log.info("enter SpringDependencyInjectionServiceClient.initInjectorWay");
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dependencyinjection/injector/application.xml"});
            Teacher teacher = (Teacher) classPathXmlApplicationContext.getBean("teacher");
            log.info("teacher=" + teacher);

        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }
}
