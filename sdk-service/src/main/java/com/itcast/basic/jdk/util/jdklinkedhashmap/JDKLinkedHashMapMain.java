package com.itcast.basic.jdk.util.jdklinkedhashmap;

/**
 * Created by treey.qian on 2018/3/22.
 */
public class JDKLinkedHashMapMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKLinkedHashMapMain");
            JDKLinkedHashMap jdkLinkedHashMap = new JDKLinkedHashMap();
            jdkLinkedHashMap.put("name", "admin");
            jdkLinkedHashMap.put(null, null);
            jdkLinkedHashMap.put("name", "root");
            jdkLinkedHashMap.put("sex", "man");
            System.out.println(" jdkLinkedHashMap=" + jdkLinkedHashMap
                    + " name=" + jdkLinkedHashMap.get("name")
                    + " isContainValue=" + jdkLinkedHashMap.containsValue("man"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
