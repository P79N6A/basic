package com.itcast.basic.generictype;

/**
 * Created by qfl on 16/4/23.
 * 这是一个泛型类
 * 基本数据类型不能作为泛型的类型参数传入
 * 泛型类的声明: class className <T>即 <T>用来声明泛型类型为T
 * 泛型域的声明:private T parameter
 * 泛型方法的声明:public <E> void setParameter(E e) {}
 * <T extends Number>表示泛型类型T是Number的子类
 * <T super Integer>表示泛型类型T是Number的父类
 * <?>表示任意类型只能声明不能实例化
 * (List<?> lists = new ArrayList<Integer>()正确)
 * (List<?> lists = new ArrayList<?>()错误)
 * 泛型继承的准则:
 * List<? extends Number> 是List<Integer>的父类
 * Collection<? extends Number>是List<? extends Number>的父类
 */
public class GenericClass<T> {

    protected T parameter;

    public GenericClass() {
    }

    public T getParameter() {
        return parameter;
    }

    public <E extends T> void setParameter(E e) {
        parameter = e;
    }
}
/*
 *泛型擦除后的代码如下:
 * public class GenericClass {
 *    private Object parameter;
 *     public GenericClass() {
 *   }
 *
 *   public Object getParameter() {
 *      return parameter;
 *   }
 *
 *   public  void setParameter(Object e) {
 *      parameter = e
 *     }
 *  }
 * */