package com.itcast.basic.jdk.lang.annotation;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/30.
 */
public class AnnotationObject {
    @Authority
    public void sys(@HttpSign String name) {
        @HttpSign int i = 0;

        List<@HttpSign String> list = new ArrayList<>();

        @HttpSign Package pack = AnnotationObject.class.getPackage();
    }

}
