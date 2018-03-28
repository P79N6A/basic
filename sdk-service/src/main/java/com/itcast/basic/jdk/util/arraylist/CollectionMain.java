package com.itcast.basic.jdk.util.arraylist;

/**
 * Created by treey.qian on 2018/3/20.
 */
public class CollectionMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into CollectionMain");
            JDKArrayList jdkArrayList = new JDKArrayList();
            for (int i = 0; i < 30; i++) {
                jdkArrayList.add(i);
            }
            jdkArrayList.add(10, 29);
            jdkArrayList.remove(2);
            jdkArrayList.remove(new Integer(17));
            System.out.println("jdkArrayList= " + jdkArrayList
                    + " elements[9]=" + jdkArrayList.get(10)
                    + " isContains=" + jdkArrayList.contains(22)
                    + " index=" + jdkArrayList.indexOf(29)
                    + " last index=" + jdkArrayList.lastIndexOf(29));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
