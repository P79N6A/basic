package com.itcast.basic;

import com.itcast.basic.jdk.lang.classloader.classloader.ClassFileObject;
import com.itcast.basic.test.Object1;
import org.apache.catalina.loader.StandardClassLoader;
import org.apache.catalina.loader.WebappClassLoader;
import org.apache.catalina.startup.Bootstrap;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * Created by treey.qian on 2018/3/27.
 */
public class TestStatic {
    public static void main(String[] args) {
        try {
            System.out.println("enter into TestStatic ");
//            FileInputStream fileInputStream = new FileInputStream("e:\\ClassFileObject.class");
//            int i = -1;
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            while ((i = fileInputStream.read()) != -1) {
//                byteArrayOutputStream.write(i);
//            }
//            byte[] bytes = byteArrayOutputStream.toByteArray();
//            System.out.println("size of bytes is " + bytes.length);
//            String className = ClassFileObject.class.getName();
//            SimpleLoader simpleLoader = new SimpleLoader(bytes, className);
//            Class classType = simpleLoader.loadClass(className);
//            ClassFileObject classFileObject = (ClassFileObject) classType.newInstance();
//            System.out.println("classType= " + classType + " classFileObject=" + classFileObject);
//            ClassFileObject o = (ClassFileObject) classType.newInstance();
//            System.out.print("simpleLoader=" + simpleLoader + " " + o.id);

//            Class classes = Class.forName(ClassFileObject.class.getName());
//            System.out.print("classes=" + classes);
//            Class class0 = ClassFileObject.class;
//            System.out.print("class0=" + class0);
//            String dir = System.getProperty("java.ext.dirs");
//            System.out.println("dir=" + dir);
//            String[] dirs = dir.split(";");
//            for (String d : dirs) {
//                System.out.println(d);
//            }
//            String dir0 = System.getProperty("java.class.path");
//            System.out.println("dir0=" + dir0);
//            dirs = dir0.split(";");
//            for (String d : dirs) {
//                System.out.println(d);
//            }
            Object1 object1 = new Object1();
            object1.sysHello();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SimpleLoader extends ClassLoader {

        private byte[] bytes;
        private String className;

        public SimpleLoader(byte[] bytes, String className) {
            this.bytes = bytes;
            this.className = className;
        }

        @Override
        public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            return super.loadClass(name, resolve);
        }

        @Override
        public Class<?> findClass(String name) throws ClassNotFoundException {
            return defineClass(className, bytes, 0, bytes.length);
        }
    }


}

