package com.itcast.basic.jdk.util.priorityqueue;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class JDKPriorityQueueMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKPriorityQueueMain");
            JDKPriorityQueue jdkPriorityQueue = new JDKPriorityQueue();
            for (int i = 0; i < 10; i++) {
                jdkPriorityQueue.add(i);
            }
            jdkPriorityQueue.remove(2);
            System.out.println("jdkPriorityQueue=" + jdkPriorityQueue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
