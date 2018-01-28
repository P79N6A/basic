package com.itcast.basic.generictype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qfl on 16/4/23.
 * java虚拟机泛型处理的思考:
 */
public class GenericClassDemo {
    public static void main(String[] args) {

        System.out.println("-----------------------灵异的泛型(泛型检查和泛型擦除)------------------------------");
        /*
         * 代码执行透析:
         *  ArrayList<String> stringArrayList = new ArrayList<String>();
         *  首先ArrayList<String> stringArrayList定义一个指向字符串集合的引用
         *  其次编译器检查该引用执行的对象是否是字符串类型的集合对象(如果不是则编译检查不通过)
         *  最后编译器编译(擦除泛型的值保留原始值List stringArrayList = new ArrayList())
         */
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();
        System.out.println(stringArrayList.getClass() == integerArrayList.getClass());//true
        GenericClass<String> genericClass=new GenericSubClass("Lily");
        System.out.println("parameter value is "+genericClass.getParameter());

    }
}
