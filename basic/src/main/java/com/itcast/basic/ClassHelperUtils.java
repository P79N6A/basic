package com.itcast.basic;

import com.itcast.basic.spring.config.transcation.GeneratorDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qfl on 16/5/11.
 */
public class ClassHelperUtils {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/itcast/basic/spring/config/transcation/applicationContext.xml");
        GeneratorDao jdbcUtils = (GeneratorDao) context.getBean("userDao");
        System.out.println("size is " + jdbcUtils.query("select * from t_users"));


    }
}