package com.itcast.basic.jdk.lang.reflect.reflect;

import java.lang.annotation.*;

/**
 * Created by treey.qian on 2018/2/1.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface AbstractBean {
    String name() default "unDefined";
}
