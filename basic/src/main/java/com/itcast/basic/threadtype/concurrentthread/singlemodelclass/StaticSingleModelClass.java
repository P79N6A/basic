package com.itcast.basic.threadtype.concurrentthread.singlemodelclass;

/**
 * 线程安全的单例模式
 * 刨析:根据java jvm类的初始化机制
 * (
 * <p/>
 * 类的<clinit>方法是由编译器收集类中的静态代码块语句和静态变量赋值语句组合而成,编译器的收集顺序取决于语句在源代码中出现的顺序
 * <clinit>方法不同于类的构造方法 不会被显式调用 虚拟机会保证父类的<clinit>方法会在子类的<clinit>方法之前被调用
 * 所以java第一个调用<clinit>方法的类一定是java.lang.Object类
 * 由于父类的<clinit>方法总是在子类的<clinit>方法之前调用 因此父类的静态代码块和静态变量赋值语句的执行必定在子类的静态代码块和静态变量赋值语句前执行
 * 类和接口的<clinit>方法不是必须的 当类和接口中不存在静态代码块语句和静态变量赋值语句时 虚拟机不会为该类生成<clinit>方法
 * 接口实现类初始化时不会调用接口的<clinit>方法
 * 虚拟机保证<clinit>方法在多线程环境下仍然可以保证正确的加锁和同步
 * <p/>
 * )
 * 缺点:只要调用单例类的方法 静态变量就会被初始化 不可控
 */
public class StaticSingleModelClass {
    public static void main(String[] args) {

    }
}

//(立即加载方式)饥汉变形1
class FirstStaticConnectionUtils {
    private static FirstStaticConnectionUtils firstStaticConnectionUtils = new FirstStaticConnectionUtils();

    public static FirstStaticConnectionUtils getFirstStaticConnectionUtils() {
        return firstStaticConnectionUtils;
    }

    public void sysHello() {
        System.out.println("hello world");
    }

}

//(立即加载方式)饥汉变形2
class SecondStaticConnectionUtils {
    private static SecondStaticConnectionUtils secondStaticConnectionUtils;

    static {
        secondStaticConnectionUtils = new SecondStaticConnectionUtils();
    }

    public static SecondStaticConnectionUtils getSecondStaticConnectionUtils() {
        return secondStaticConnectionUtils;
    }

    public void sysHello() {
        System.out.println("hello world");
    }
}
