package com.itcast.basic.jdk.lang.reflect.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by treey.qian on 2018/2/1.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface ClassBean {
    String name() default "notDefined";

    String paramters() default "notDefined";

    String returnTypeName() default "notDefined";
}
