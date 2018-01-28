package com.itcast.basic.javabean.reflecttype;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by qfl on 16/4/22.
 */
public class ReflectClassUtils {
    private Person person;

    public ReflectClassUtils(Person person) {
        this.person = person;
    }

    /**
     * 得到本类声明的注解
     */
    public void printOwnAnnotation() {
        Annotation[] annotations = person.getClass().getDeclaredAnnotations();
        for (Annotation annotation : annotations)
            System.out.println(annotation.annotationType().toString() + " annotation type name is " + annotation.annotationType().getName());
    }

    /**
     * 得到所有的注解(包括从父类继承的注解)
     */
    public void printAnnotations() {
        Annotation[] annotations = person.getClass().getAnnotations();
        for (Annotation annotation : annotations)
            System.out.println(annotation.annotationType().toString() + " annotation type name is " + annotation.annotationType().getName());
    }

    /**
     * 得到构造方法(public和非public)
     */
    public void printOwnConstructors() {
        Constructor[] constructors = person.getClass().getDeclaredConstructors();
        for (Constructor constructor : constructors)
            System.out.println("constructor name is " + constructor.getName());
    }

    /**
     * 得到所有的public的方法(包括父类继承和本类声明的方法)
     */
    public void printPublicMethods() {
        Method[] methods = person.getClass().getMethods();
        for (Method method : methods)
            System.out.println("method name is " + method.getName());
    }

    /**
     * 得到所有的public的方法(包括父类继承和本类声明的方法)
     */
    public void printOwnMethods() {
        Method[] methods = person.getClass().getDeclaredMethods();
        for (Method method : methods)
            System.out.println("method name is " + method.getName());
    }

    /**
     * 得到本类中所有的域
     */
    public void printOwnFields() {
        Field[] fields = person.getClass().getDeclaredFields();
        try {
            for (Field field : fields)
                System.out.println(field.getName() + " value is " + field.get(person));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到所有的public的域
     */
    public void printFields() {
        Field[] fields = person.getClass().getFields();
        try {
            for (Field field : fields)
                System.out.println(field.getName() + " value is " + field.get(person));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void excePublicMethodByName(String name, Class[] parameterTypes, Object[] args) {
        try {
            Method method = person.getClass().getDeclaredMethod(name, parameterTypes);
            System.out.println(name + "方法执行结果为:" + method.invoke(person, args));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void excePrivateMethodByName(String name, Class[] parameterTypes, Object[] args) {
        try {
            Method method = person.getClass().getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            System.out.println(name + "方法执行结果为:" + method.invoke(person, args));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Person exceConstructor(Class[] parameterTypes, Object[] parameterValues) {
        Person newPerson = null;
        try {
            Constructor constructor = person.getClass().getConstructor(parameterTypes);
            newPerson = (Person) constructor.newInstance(parameterValues);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return newPerson;
    }
}
