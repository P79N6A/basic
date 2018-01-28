package com.itcast.basic.spring.config.ioc.applicationcontextmessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/**
 * Created by qfl on 16/7/30.
 */
public class TestLocalMessageResource {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IntrospectionException {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/itcast/basic/spring/config/ioc/applicationcontextmessage/applicationContext.xml");
        String name = context.getMessage("name", null, Locale.CHINA);
        System.out.println(name);
    }
}
