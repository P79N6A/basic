package com.itcast.basic.jdk.util.weakhashmap;

import java.util.LinkedHashMap;

/**
 * Created by treey.qian on 2018/3/22.
 */
public class JDKWeakHashMapMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKWeakHashMapMain");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("name", "admin");
            linkedHashMap.put("sex", "man");
            linkedHashMap.put("age", "25");
            linkedHashMap.put("school", "wuhan");
            System.out.println("element is " + linkedHashMap.get("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
