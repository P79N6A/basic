package com.itcast.basic.jdk.util.arraydeque;

/**
 * Created by treey.qian on 2018/3/22.
 */
public class JDKArrayDequeMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKArrayDequeMain");
            JDKArrayDeque jdkArrayDeque = new JDKArrayDeque();
            for (int i = 0; i < 30; i++) {
                jdkArrayDeque.push(i);
            }

            System.out.println(
                    "pop=" + jdkArrayDeque.pop()
                            + " jdkArrayDeque=" + jdkArrayDeque);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
