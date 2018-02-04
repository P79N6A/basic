package com.itcast.basic.jdk.lang.reflect.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by treey.qian on 2018/2/1.
 */
public class ClassUtilTools {


    /**
     * 输出类的字段域
     *
     * @param classType 类字节码
     */
    public static void sysDeclareFields(Class classType) {
        if (classType != null) {
            Field[] fields = classType.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("field name is " + field.getName() + " field type is " + field.getType().getName());
            }
        }
    }

    /**
     * 输出父类字段域
     *
     * @param classType 类字节码
     */
    public static void sysAllFields(Class classType) {
        if (classType != null) {
            Field[] fields = classType.getFields();
            for (Field field : fields) {
                System.out.println("field name is " + field.getName() + " field type is " + field.getType().getName());
            }
        }
    }

    /**
     * 输出类构造方法
     *
     * @param classType 类字节码
     */
    public static void sysConstructor(Class classType) throws Exception {
        if (classType != null) {
            Constructor constructor = classType.getDeclaredConstructor();
            System.out.println("constructor name is " + constructor.getName());
        }
    }

    /**
     * 输出类方法
     *
     * @param classType 类字节码
     */
    public static void sysMethods(Class classType) {
        if (classType != null) {
            Method[] methods = classType.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("name of method is " + method.getName());
            }
        }
    }

    /**
     * 输出父类方法
     *
     * @param classType 类字节码
     */
    public static void sysAllMethods(Class classType) {
        if (classType != null) {
            Method[] methods = classType.getMethods();
            for (Method method : methods) {
                System.out.println("name of method is " + method.getName());
            }
        }
    }

    /**
     * 输出类注解
     *
     * @param classType 类字节码
     */
    public static void sysAnnotations(Class classType) {
        if (classType != null) {
            Annotation[] annotations = classType.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("type of annotation is " + annotation.annotationType());
            }
        }
    }


    /**
     * 输出类注解
     *
     * @param classType 类字节码
     */
    public static void sysAllAnnotations(Class classType) {
        if (classType != null) {
            Annotation[] annotations = classType.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("type of annotation is " + annotation.annotationType());
            }
        }
    }

    /**
     * 调用构造方法
     *
     * @param classType 类字节码
     */
    public static void invokeConstructor(Class classType) throws Exception {
        if (classType != null) {
            Constructor constructor = classType.getDeclaredConstructor();
            constructor.newInstance();
        }
    }

    /**
     * 调用公有方法
     *
     * @param classType 类字节码
     */
    public static void invokePubMethod(Class classType) throws Exception {
        if (classType != null) {
            Constructor constructor = classType.getConstructor();
            Object object = constructor.newInstance();
            Method method = classType.getDeclaredMethod("sysHello", null);
            method.invoke(object);
        }
    }

    /**
     * 调用私有方法
     *
     * @param classType 类字节码
     */
    public static void invokePriMethod(Class classType) throws Exception {
        if (classType != null) {
            Constructor constructor = classType.getConstructor();
            Object object = constructor.newInstance();
            Method method = classType.getDeclaredMethod("doJob", null);
            method.setAccessible(true);
            method.invoke(object);
        }
    }

    /**
     * 得到类父类
     *
     * @param classType 类字节码
     */
    public static void sysSuper(Class classType) {
        if (classType != null) {
            Class superClass = classType.getSuperclass();
            System.out.println("superClass is " + superClass.getName());
        }
    }

    /**
     * 得到接口
     * @param classType 类字节码
     */
    public static void sysInterfaces(Class classType) {
        if (classType != null) {
            Class[] interfaces = classType.getInterfaces();
            for (Class info : interfaces) {
                System.out.println("name of info is " + info.getName());
            }
        }
    }

    private ClassUtilTools() {

    }
}
