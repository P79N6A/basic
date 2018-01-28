package com.itcast.basic.classtype.innerclass;

/**
 * Created by qfl on 16/4/21.
 * 对非静态内部类 静态内部类 局部内部类 匿名内部类的思考:
 * 非静态内部类:
 * 非静态内部类在编译时编译器会默认将外部类的引用通过内部类的构造函数传入即非静态内部类持有一个指向外部类的引用
 * 在非静态内部类中可以访问外部类的所有属性(域和方法) 非静态内部类中不能声明静态属性(静态代码块 静态方法 静态变量)
 * 实例化非静态内部类必须依靠外部类的实例 OutterClass.InnerClass inner = (new OutterClass()).new InnerClass();
 * 静态内部类:
 * 静态内部类不会持有对外部类的引用 静态内部类只能访问外部类的静态属性(静态域和静态方法)
 * 实例化静态内部类可以通过外部类类名即可 OutterClass.InnerClass inner = new OutterClass.InnerClass();
 * 局部内部类:
 * 定义在方法内部或者方法块内部的持名类 局部内部类只能访问局部常量(final)
 * 匿名内部类:
 * 定义在方法内部或方法块内部的无名类 匿名内部类没有构造方法 匿名内部类只能访问局部常量(final)
 */
public class OutterClass {

    private String name;
    private static String country;

    public String getName() {
        return name;
    }

    public static String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setCountry(String country) {
        OutterClass.country = country;
    }

    class InnerClass {

    }

    static class StaticInnerClass {

    }

    public OutterClass() {

    }

    public void sysValue() {


        class PartialClass {
            public void sysHello() {
                System.out.println("Hello World,i am Lily");
            }
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Starting....");
            }
        }).start();
    }
}
