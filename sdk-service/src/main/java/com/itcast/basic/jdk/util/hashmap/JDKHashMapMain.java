package com.itcast.basic.jdk.util.hashmap;

/**
 * Created by treey.qian on 2018/3/21.
 */
public class JDKHashMapMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKHashMapMain");
            JDKHashMap jdkHashMap = new JDKHashMap();
            jdkHashMap.put(null, null);
            jdkHashMap.put("name", "root");
            jdkHashMap.put("sex", "man");
            Object oldV = jdkHashMap.put("name", "admin");
            jdkHashMap.remove("name");
            System.out.println("oldV=" + oldV
                    + " jdkHashMap=" + jdkHashMap
                    + " isContainValue=" + jdkHashMap.containsKey("name")
                    + " isContainValue=" + jdkHashMap.containsValue("admin"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
