package com.itcast.basic.classloadertype;

import com.itcast.basic.compilertype.compilesource.compilesourcefile.AnimalActions;

import java.net.MalformedURLException;

/**
 * Created by qfl on 16/5/13.
 * 这是一个测试类加载器使用的例子
 */
public class ClassLoaderUtilsDemo {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class classes = ClassLoaderUtils.loadClassByURL(System.getProperty("user.dir") + "/src/com/itcast/basic/compilertype/compilesource/compileclassfile/", "com.itcast.basic.compilertype.compilesource.compilesourcefile.AnimalActions");
        ((AnimalActions) classes.newInstance()).sysHello();
    }
}
