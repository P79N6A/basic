package com.itcast.basic.jdk.util.concurrent.concurrenthashmap;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class JDKConcurrentHashMapMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKConcurrentHashMapMain");
            JDKConcurrentHashMap jdkConcurrentHashMap = new JDKConcurrentHashMap();
            jdkConcurrentHashMap.put("name", "admin");
            jdkConcurrentHashMap.put("sex", "man");
            jdkConcurrentHashMap.put("school", "wuhan");
            jdkConcurrentHashMap.remove("sex");
            System.out.println("name is " + jdkConcurrentHashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
