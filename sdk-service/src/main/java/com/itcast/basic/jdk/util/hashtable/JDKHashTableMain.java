package com.itcast.basic.jdk.util.hashtable;

/**
 * Created by qfl on 2018/3/21.
 */
public class JDKHashTableMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKHashTableMain");
            JDKHashTable jdkHashTable = new JDKHashTable();
            jdkHashTable.put(null, null);
            jdkHashTable.put("name", "lily");
            jdkHashTable.put("sex", "man");
            jdkHashTable.put("name", "treey");
            jdkHashTable.remove("name");
            System.out.println(
                    " isContainValue=" + jdkHashTable.containsValue("man")
                            + " isContainKey=" + jdkHashTable.containKey("name")
                            + " jdkHashTable=" + jdkHashTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
