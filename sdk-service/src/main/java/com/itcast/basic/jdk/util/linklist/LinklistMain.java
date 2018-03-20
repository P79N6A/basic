package com.itcast.basic.jdk.util.linklist;

/**
 * Created by treey.qian on 2018/3/20.
 */
public class LinklistMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into LinklistMain");
            JDKLinklist jdkLinklist = new JDKLinklist();
            for (int i = 0; i < 30; i++) {
                jdkLinklist.add(i);
            }
            jdkLinklist.remove(new Integer(16));
            System.out.println("jdkLinklist is " + jdkLinklist);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
