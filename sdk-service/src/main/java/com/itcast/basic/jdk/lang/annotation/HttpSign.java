package com.itcast.basic.jdk.lang.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/1/30.
 *
 * @Target注解声明该注解作用对象范围
 * @Inherited注解声明该注解作用对象被继承时仍然有效
 * @Retentation声明该注解生效的保留时间
 * @Documented声明该注解将会包含在javadoc文件中
 */
@Documented
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE})
public @interface HttpSign {
    String version() default "1.0";

    String protocol() default "http";

    String port() default "80";
}
