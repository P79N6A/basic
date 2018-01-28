package com.itcast.basic.javabean.introspectiontype;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qfl on 16/4/22.
 */
public class InstrospectionUtils {
    private Person person;

    public InstrospectionUtils(Person person) {
        this.person = person;
    }

    public void printAllDeclaredMethods() {
        Method[] methods = person.getClass().getDeclaredMethods();
        for (Method method : methods)
            System.out.println(method.getName());
    }

    public void printAllDeclaredFields() {
        Field[] fields = person.getClass().getDeclaredFields();
        for (Field field : fields)
            System.out.println(field.getName());
    }


    public Map<String, Object> beanToMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = person.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                String fieldName = field.getName();
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, person.getClass());
                Method method = propertyDescriptor.getReadMethod();
                map.put(fieldName, method.invoke(person, new Object[]{}));
            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
