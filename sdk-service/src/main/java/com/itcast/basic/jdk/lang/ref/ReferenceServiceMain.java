package com.itcast.basic.jdk.lang.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/1/31.
 */
public class ReferenceServiceMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into ReferenceServiceMain");
            ReferenceQueue referenceQueue = new ReferenceQueue();
            System.out.println("***************软引用********************");
            String admin = new String("admin");
            SoftReference<String> stringSoftReference = new SoftReference<String>(admin, referenceQueue);
            System.out.println("gc before string SoftReference=" + stringSoftReference.get() + " referenceQueue=" + referenceQueue.poll());
            admin = null;
            System.gc();
            System.out.println("gc after string SoftReference=" + stringSoftReference.get() + " referenceQueue=" + referenceQueue.poll());
            System.out.println("***************软引用********************");

            System.out.println("***************虚引用********************");
            String name = "lily";
            WeakReference<String> weakReference = new WeakReference<String>(new String("admin"), referenceQueue);
            System.out.println("gc before weakReference=" + weakReference.get() + " name=" + name + " referenceQueueElement=" + referenceQueue.poll());
            System.gc();
            System.out.println("gc after weakReference=" + weakReference.get() + " name=" + name + " referenceQueueElement=" + referenceQueue.poll());
            System.out.println("***************虚引用********************");

            System.out.println("+++++++++++++++++弱引用+++++++++++++++++");
            String root = new String("root");
            PhantomReference<String> phantomReference = new PhantomReference<>(root, referenceQueue);
            System.out.println("gc before string phantomReference=" + phantomReference.get() + " root=" + root + " referenceQueue=" + referenceQueue.poll());
            System.gc();
            System.out.println("gc after string phantomReference=" + phantomReference.get() + " root=" + root + " referenceQueue=" + referenceQueue.poll());
            System.out.println("+++++++++++++++++弱引用+++++++++++++++++");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
