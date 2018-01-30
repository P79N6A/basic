package com.itcast.basic.jdk.lang.annotation;

import java.lang.annotation.Repeatable;

@Repeatable(Authorities.class)
public @interface Authority {

    String role() default "customer";

    String name() default "customer";

}