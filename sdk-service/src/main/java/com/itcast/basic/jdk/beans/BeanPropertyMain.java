package com.itcast.basic.jdk.beans;

import com.itcast.basic.jdk.beans.beans.BeanFactory;
import com.itcast.basic.jdk.beans.beans.BeanListener;
import com.itcast.basic.jdk.beans.beans.Person;

import java.util.Map;

/**
 * Created by Administrator on 2018/2/4.
 */
public class BeanPropertyMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into BeanPropertyMain");
            Person person = new Person();
            person.setName("admin");
            person.addPropertyChangeListener(new BeanListener());
            person.setName("root");
            Map<String, Object> bean = BeanFactory.beanMap(person);
            for (Map.Entry entry : bean.entrySet()) {
                System.out.println("key is " + entry.getKey() + " value is " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
