package com.itcast.basic.spring.config.ioc.applicationcontextresource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by qfl on 16/7/30.
 */
public class TestApplicationContextResource {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IntrospectionException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/itcast/basic/spring/config/ioc/applicationcontextresource/applicationContext.xml");
        Resource resource = context.getResource("com/itcast/basic/spring/config/ioc/applicationcontextresource/");
        System.out.println(resource.getDescription() + " " + resource.getFile().getName());
    }
}
