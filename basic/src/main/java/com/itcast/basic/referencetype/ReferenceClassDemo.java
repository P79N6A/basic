package com.itcast.basic.referencetype;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by qfl on 16/4/23.
 * java.lang.ref包下提供 强弱软虚 引用
 * 强引用:
 * 形如String str=new String("hello") 通过new创建的对象的引用
 * 强引用指向的对象不被gc回收 即使jvm内存爆出OutOfMemory异常
 * 可以通过将强引用置为null来释放强引用指向的对象
 * 软引用(SoftReference):
 * 形如SoftReference<String> stringSoftReference = new SoftReference<String>("hello world!");
 * 当没有其他引用指向软引用所指向的对象时 JVM内存不够会自动回收软引用指向的对象(用软引用可以防止出现OutOfMemory异常)
 * 虚引用:
 * 形如WeakReference<Integer> integerWeakReference = new WeakReference<Integer>(new Integer(20))
 * 当虚引用指向的对象不存在其他引用时 虚拟机把该对象放到虚引用队列中等待JVM回收(执行System.gc()方法后回收虚引用)
 * 弱引用:
 * 形如PhantomReference<Integer> phantomReference = new PhantomReference<Integer>(new Integer(30), new ReferenceQueue<Integer>());
 * 弱引用必须和引用队列一起使用 当弱引用指向的对象不被其他引用所指向时 垃圾回收器随时回收弱引用
 * 主要回收堆上的内存空间 至于字符常量另议(对于形如 String name= "Lily";的字符串常量 执行System.gc()方法不会被回收)
 */
public class ReferenceClassDemo {
    public static void main(String[] args) {
        System.out.println("-------------------------------软引用-------------------------------");
        SoftReference<String> stringSoftReference = new SoftReference<String>(new String("hello world"));
        System.gc();
        System.out.println("软引用不会被回收:" + stringSoftReference.get());
        System.out.println("-------------------------------字符串对象回收----------------------------------------");
        String name = new String("Lily");
        WeakReference<String> stringWeakReference = new WeakReference<String>(name);
        System.gc();
        System.out.println("name " + stringWeakReference.get());
        name = null;
        System.gc();
        System.out.println("name " + stringWeakReference.get());
        System.out.println("-------------------------------字符串常量不会被回收----------------------------------------");
        WeakReference<String> stringWeakReference1 = new WeakReference<String>("Lucy");
        System.out.println("执行gc前:" + stringWeakReference1.get());
        System.gc();
        System.out.println("执行gc后" + stringWeakReference1.get());
        System.out.println("-------------------------------虚引用----------------------------------------");
        PhantomReference<Integer> phantomReference = new PhantomReference<Integer>(new Integer(30), new ReferenceQueue<Integer>());
        System.out.println("执行gc前:" + phantomReference.get());
        System.gc();
        System.out.println("执行gc后:" + phantomReference.get());
    }
}