package com.itcast.basic.jdk.generic.generic;

/**
 * Created by Administrator on 2018/2/3.
 */
public class GenericTool {

    public static <T extends Number> T getObject(T data) {
        return data;
    }


}
