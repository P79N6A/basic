package com.itcast.basic.jdk.util.linklist;

/**
 * Created by treey.qian on 2018/3/20.
 */
public class LinklistMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into LinklistMain");
            JDKLinklist jdkLinklist = new JDKLinklist();
            for (int i = 0; i < 20; i++) {
                jdkLinklist.add(i);
            }
//            jdkLinklist.remove(new Integer(16));
//            jdkLinklist.add(14, 100);
//            jdkLinklist.remove(0);
            jdkLinklist.push(200);
            jdkLinklist.push(300);
            System.out.println(
                    "pop=" + jdkLinklist.pop() +
                            " lastindexof=" + jdkLinklist.indexOf(3) +
                            " indexof=" + jdkLinklist.indexOf(3) +
                            " elements[10]=" + jdkLinklist.get(10) +
                            " contains=" + jdkLinklist.contains(5) +
                            " jdkLinklist is " + jdkLinklist);

//            LinkedList linkedList = new LinkedList();
//            linkedList.push(10);
//            linkedList.push(61);
//            System.out.println("pop=" + linkedList.pop());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
