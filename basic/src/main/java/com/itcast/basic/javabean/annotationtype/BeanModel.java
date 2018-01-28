package com.itcast.basic.javabean.annotationtype;

import java.lang.annotation.*;

/**
 * Created by qfl on 16/4/22.
 * 对注解的思考:
 * 注解仅仅是java中的一种标示没有特殊意义
 *
 * @Documented:标明该注解将会包含到javaDoc文档中
 * @inherited:标明该注解可以由子类继承
 * @Retention:标明该注解保留时间 RetentionPoicy.SOURCE 源文件保留
 * RetentionPoicy.CLASS  类加载时保留
 * RetentionPoicy.RUNTIME 运行时保留
 * @Target:标明该注解作用的范围 ElementType.TYPE 用于类 接口 枚举 注解
 * ElementType.FIELD 用于字段
 * ElementType.METHOD 用于方法
 * ElementType.PACKAGE 用于包
 * ElementType.CONSTRUCTOR 用于构造方法
 * ElementType.LOCAL_VARIABLE 用于局部变量
 * ElementType.PARAMETER 用于信息描述
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
public @interface BeanModel {
    String value() default "";

    String name() default "BeanModel";

    long UUID() default 1234567890;
}

/**
 * 编译后的注解
 * <p/>
 * <p/>
 * public interface com.itcast.basic.javabean.annotationtype.BeanModel extends java.lang.annotation.Annotation
 * SourceFile: "BeanModel.java"
 * RuntimeVisibleAnnotations:
 * 0: #17(#4=e#18.#19)
 * 1: #20(#4=[e#21.#22,e#21.#23,e#21.#24,e#21.#25])
 * minor version: 0
 * major version: 51
 * flags: ACC_PUBLIC, ACC_INTERFACE, ACC_ABSTRACT, ACC_ANNOTATION
 * Constant pool:
 * #1 = Class              #26            //  com/itcast/basic/javabean/annotationtype/BeanModel
 * #2 = Class              #27            //  java/lang/Object
 * #3 = Class              #28            //  java/lang/annotation/Annotation
 * #4 = Utf8               value
 * #5 = Utf8               ()Ljava/lang/String;
 * #6 = Utf8               AnnotationDefault
 * #7 = Utf8
 * #8 = Utf8               name
 * #9 = Utf8               BeanModel
 * #10 = Utf8               UUID
 * #11 = Utf8               ()J
 * #12 = Long               1234567890l
 * #14 = Utf8               SourceFile
 * #15 = Utf8               BeanModel.java
 * #16 = Utf8               RuntimeVisibleAnnotations
 * #17 = Utf8               Ljava/lang/annotation/Retention;
 * #18 = Utf8               Ljava/lang/annotation/RetentionPolicy;
 * #19 = Utf8               RUNTIME
 * #20 = Utf8               Ljava/lang/annotation/Target;
 * #21 = Utf8               Ljava/lang/annotation/ElementType;
 * #22 = Utf8               FIELD
 * #23 = Utf8               METHOD
 * #24 = Utf8               CONSTRUCTOR
 * #25 = Utf8               TYPE
 * #26 = Utf8               com/itcast/basic/javabean/annotationtype/BeanModel
 * #27 = Utf8               java/lang/Object
 * #28 = Utf8               java/lang/annotation/Annotation
 * {
 * public abstract java.lang.String value();
 * flags: ACC_PUBLIC, ACC_ABSTRACT
 * AnnotationDefault:
 * default_value: s#7
 * public abstract java.lang.String name();
 * flags: ACC_PUBLIC, ACC_ABSTRACT
 * AnnotationDefault:
 * default_value: s#9
 * public abstract long UUID();
 * flags: ACC_PUBLIC, ACC_ABSTRACT
 * AnnotationDefault:
 * default_value: J#12}
 */