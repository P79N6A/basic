package com.itcast.basic.spring;

import com.itcast.basic.spring.config.aop.dynamic.introductionadvisor.ServiceInterface;
import com.itcast.basic.spring.config.basic.BasicSpringConfig;
import com.itcast.basic.spring.config.ioc.beanlife.BeanInitProcessor;
import com.itcast.basic.spring.config.ioc.beanproperties.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by qfl on 16/7/28.
 */
public class SpringDemoTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IntrospectionException {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/itcast/basic/spring/config/basic/applicationContext.xml");
        BasicSpringConfig config = (BasicSpringConfig) context.getBean("basicSpringConfig");
        System.out.println(config.toString());
        System.out.println(config.getAlias().size() + " " + config.getCards().size() + " " + config.getLives().size() + " " + config.getConfig().size());

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("com/itcast/basic/spring/config/ioc/beanlife/applicationContext.xml");
        BeanInitProcessor beanInitProcessor = (BeanInitProcessor) classPathXmlApplicationContext.getBean("beanInitProcessor");
        beanInitProcessor.sysHello();

        ClassPathXmlApplicationContext personContext = new ClassPathXmlApplicationContext("com/itcast/basic/spring/config/ioc/beanproperties/applicationContext.xml");
        Person person1 = (Person) context.getBean("personFirst");
        Person person2 = (Person) context.getBean("personFirst");
        System.out.println(person1 == person2);

        Person person3 = (Person) context.getBean("personSecond");
        Person person4 = (Person) context.getBean("personSecond");
        System.out.println(person3 == person4);

        ApplicationContext advice = new ClassPathXmlApplicationContext("com/itcast/basic/spring/config/aop/dynamic/introductionadvisor/applicationContext.xml");
        ServiceInterface saveService = (ServiceInterface) advice.getBean("introductionService");
        saveService.save();
        saveService.query();


        ApplicationContext acontext = new ClassPathXmlApplicationContext("com/itcast/basic/spring/config/aop/dynamic/simpleadvisors/applicationContext.xml");
        com.itcast.basic.spring.config.aop.dynamic.simpleadvisors.ServiceInterface serviceInterface = (com.itcast.basic.spring.config.aop.dynamic.simpleadvisors.ServiceInterface) acontext.getBean("proxyBeanFactory");
        serviceInterface.save();
        serviceInterface.delete();
        serviceInterface.update();
        
    }
}
