package com.itcast.basic.jdk.lang.classloader;

import com.itcast.basic.jdk.lang.classloader.classloader.ClassFileObject;
import com.itcast.basic.jdk.lang.classloader.classloader.ClassLoaderUtils;
import com.itcast.basic.jdk.lang.classloader.classloader.SimpleClassLoader;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Method;

/**
 * Created by treey.qian on 2018/2/2.
 */
public class ClassLoaderMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into ClassLoaderMain");
            SimpleClassLoader simpleClassLoader = new SimpleClassLoader(Thread.currentThread().getContextClassLoader(), ClassFileObject.class);
            Class classType = simpleClassLoader.loadClass("ClassFileObject");
            //类字节码和类加载器决定类的类型 此处强制转换不成功
//            ClassFileObject classFileObject= (ClassFileObject) classType.newInstance();
            Method method = classType.getMethod("getName");
            System.out.println("name is " + method.invoke(classType.newInstance()));

            Class c = ClassLoaderUtils.loadClass(ClassFileObject.class.getName());
            ClassFileObject classFileObject = (ClassFileObject) c.newInstance();
            System.out.println("name is " + classFileObject.getName());

            String jarPath = "C:\\Users\\treey.qian\\.m2\\repository\\redis\\clients\\jedis\\2.8.0\\jedis-2.8.0.jar";
            Class redis = ClassLoaderUtils.loadClass(jarPath, Jedis.class.getName());
            Object redisObj = redis.newInstance();
            System.out.println("name is " + (redisObj instanceof Jedis));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
