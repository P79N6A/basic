package com.itcast.basic.jdk.lang.reflect.reflect;

/**
 * Created by treey.qian on 2018/2/1.
 */
@AbstractBean(name = "AbstractBeanFactory")
public abstract class AbstractBeanFactory {
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    protected abstract void print();

    public AbstractBeanFactory() {
        System.out.println("enter into AbstractBeanFactory");
    }

    public static void sysBeanFactory() {
        System.out.println("enter into sysBeanFactory");
    }

    private void doProcess() {
        System.out.println("enter into doProcess");
    }
}
