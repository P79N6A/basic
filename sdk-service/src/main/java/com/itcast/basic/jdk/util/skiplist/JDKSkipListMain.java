package com.itcast.basic.jdk.util.skiplist;

/**
 * Created by qfl on 2018/4/1.
 */
public class JDKSkipListMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKSkipListMain");
            JDKSkipList jdkSkipList = new JDKSkipList();
            for (int i = 0; i < 15; i++) {
                jdkSkipList.put("qfl" + i, "qfl" + i);
            }
            Object result = jdkSkipList.get("3");
            boolean isSuccess = jdkSkipList.remove("3");
            System.out.println("isSuccess=" + isSuccess + " result is " + result
                    + " " + jdkSkipList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
