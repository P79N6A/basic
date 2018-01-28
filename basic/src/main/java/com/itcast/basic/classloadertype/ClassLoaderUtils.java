package com.itcast.basic.classloadertype;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 本包将演示不同类加载器加载类的方法
 */
public class ClassLoaderUtils {

    /**
     * 上下文类加载器
     *
     * @param name 全路径类名
     * @return
     * @throws ClassNotFoundException
     */
    public static Class<?> loadClassByCurrentContext(String name) throws ClassNotFoundException {
        return Thread.currentThread().getContextClassLoader().loadClass(name);
    }

    /**
     * 自定义类加载器
     *
     * @param name 全路径类名
     * @return
     * @throws ClassNotFoundException
     */
    public static Class<?> loadClassByDefinedContext(String name) throws ClassNotFoundException {
        return new SimpleClassLoader().loadClass(name);
    }

    /**
     * 加载jar包中的类
     *
     * @param path jar包的路径
     * @param name 全路径类名
     * @return
     * @throws MalformedURLException
     * @throws ClassNotFoundException
     */
    public static Class<?> loadClassByURL(String path, String name) throws MalformedURLException, ClassNotFoundException {
        return new URLClassLoader(new URL[]{new File(path).toURI().toURL()}, Thread.currentThread().getContextClassLoader()).loadClass(name);
    }

}






























