package com.itcast.basic.jdk.lang.reflect.reflect;

/**
 * Created by treey.qian on 2018/2/1.
 */
@ClassBean(name = "BeanFactoryObject")
public class BeanFactoryObject extends AbstractBeanFactory implements BeanFactory {

    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void print() {
        System.out.println("enter into print");
    }

    public BeanFactoryObject() {
        System.out.println("this is BeanFactoryObject constructor");
    }

    public BeanFactoryObject(String name) {
        System.out.println("this is BeanFactoryObject constructor" + name);
    }

    private void doSomething() {
        System.out.println("doSomething");
    }

    @ClassBean(name = "sysHello", returnTypeName = "void", paramters = "no")
    public void sysHello() {
        System.out.println("hello world, i am lily");
    }

    @Override
    public String toString() {
        return "BeanFactoryObject{" +
                "beanName='" + beanName + '\'' +
                '}';
    }

    private void doJob() {
        System.out.println("enter into doJob");
    }
}
