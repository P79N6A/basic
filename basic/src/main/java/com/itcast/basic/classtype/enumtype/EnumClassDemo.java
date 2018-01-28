package com.itcast.basic.classtype.enumtype;

/**
 * Created by qfl on 16/4/22.
 * 所有的枚举类型都是枚举类Enum的子类
 * 枚举的方法必须在枚举引用常量后声明
 * 枚举的构造方法不能为public
 * 每一个常量都是指向该枚举子类实例的引用
 * 常量引用将在枚举的静态代码块中被初始化
 * values()方法返回一个数组(包含所有枚举常量引用)
 */
public class EnumClassDemo {

    public static void main(String[] args) {
        EnumClass.sysHello();
        EnumClass.ONE.getI();
        EnumClass.ONE.jump();
        String uuid = EnumClass.UUID;
    }
}
