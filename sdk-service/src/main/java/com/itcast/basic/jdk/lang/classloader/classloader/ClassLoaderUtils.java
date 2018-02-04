package com.itcast.basic.jdk.lang.classloader.classloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by treey.qian on 2018/2/2.
 */
public class ClassLoaderUtils {

    /**
     * 加载类
     *
     * @param name 类全路径名
     * @return
     */
    public static Class loadClass(String name) throws ClassNotFoundException {
        return Thread.currentThread().getContextClassLoader().loadClass(name);
    }

    /**
     * 加载类
     *
     * @param path jar包路径
     * @param name 类全路径
     * @return
     * @throws ClassNotFoundException
     * @throws MalformedURLException
     */
    public static Class loadClass(String path, String name) throws ClassNotFoundException, MalformedURLException {
        return new URLClassLoader(new URL[]{new File(path).toURI().toURL()}, Thread.currentThread().getContextClassLoader()).loadClass(name);
    }
}
