package com.itcast.basic.spring.ioc.dependencyinjection;

import com.itcast.basic.spring.ioc.dependencyinjection.constructor.Student;
import com.itcast.basic.spring.ioc.dependencyinjection.constructor.manyconstructors.Human;
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
//        initManyConstructorsWay();
//        initConstructorWay();
//        initInjectorWay();
        staticFactoryMethod();
//        factoryMethod();
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
            e.printStackTrace();
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

    /**
     * 多个构造方法注入
     */
    private static void initManyConstructorsWay() {
        try {
            log.info("enter SpringDependencyInjectionServiceClient.initManyConstructorsWay");
            ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/dependencyinjection/constructor/manyconstructors/application.xml"});
            Human student = (Human) classPathXmlApplicationContext.getBean("student");
            log.info("student=" + student);
            Human.InnerInfo innerInfo = (Human.InnerInfo) classPathXmlApplicationContext.getBean("inner");
            log.info("innerInfo=" + innerInfo);
            Human.StaticInnerInfo staticInnerInfo = (Human.StaticInnerInfo) classPathXmlApplicationContext.getBean("staticInnerInfo");
            log.info("staticInnerInfo=" + staticInnerInfo);
        } catch (Exception e) {
            log.info("error is {}", e);
        }
    }
}
