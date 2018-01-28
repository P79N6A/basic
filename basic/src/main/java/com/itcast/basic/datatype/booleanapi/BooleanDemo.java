package com.itcast.basic.datatype.booleanapi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qfl on 16/4/19.
 */
public class BooleanDemo {
    public static void main(String[] args) {
        System.out.println("**********************************************************");
        System.out.println("*********自动装箱和自动拆箱**********************************");
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        Boolean b = (map != null ? map.get("test") : Boolean.FALSE);
        System.out.println("不进行拆箱" + b);
        //Boolean c = (map != null ? map.get("test") : false);//运行报错
        //Boolean d = (map.get("test") ? map.get("test") : Boolean.FALSE);//运行时异常
        //Boolean e = (map == null ? true : map.get("test"));//运行报错
        /**
         *   当基本数据类型和基本数据类型包装器共同存在参与运算时包装器将拆箱
         *   Boolean c = (map != null ? map.get("test") : false)->
         *   Boolean c = Boolean.valueOf((map != null ? (map.get("test")).booleanValue() : false))
         *   Boolean b = (map != null ? map.get("test") : Boolean.FALSE)->
         *   Boolean b = (map != null ? map.get("test") : Boolean.FALSE)
         */
        System.out.println();
        System.out.println("**********************************************************");
    }
}
