package com.itcast.basic.jdk.lang.reflect.reflect;

/**
 * Created by treey.qian on 2018/2/1.
 */
public class ReflectServiceMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into InvocationServiceMain");
            Class classType = BeanFactoryObject.class;
//            ClassUtilTools.sysDeclareFields(classType);
//            ClassUtilTools.sysAllFields(classType);
//            ClassUtilTools.sysConstructor(classType);
//            ClassUtilTools.sysMethods(classType);
//            ClassUtilTools.sysAllMethods(classType);
//            ClassUtilTools.sysAnnotations(classType);
//            ClassUtilTools.sysAllAnnotations(classType);
//            ClassUtilTools.invokeConstructor(classType);
//            ClassUtilTools.invokePubMethod(classType);
//            ClassUtilTools.invokePriMethod(classType);
//            ClassUtilTools.sysSuper(classType);
            ClassUtilTools.sysInterfaces(classType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
