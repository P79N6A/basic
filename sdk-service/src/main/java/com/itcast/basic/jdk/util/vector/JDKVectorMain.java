package com.itcast.basic.jdk.util.vector;

/**
 * Created by treey.qian on 2018/3/21.
 */
public class JDKVectorMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into JDKVectorMain");
//            JDKVector jdkVector = new JDKVector();
//            for (int i = 0; i < 30; i++) {
//                jdkVector.add(i);
//            }
//            jdkVector.add(20, 200);
//            jdkVector.set(10, 100);
//            jdkVector.remove(new Integer(22));
//            jdkVector.remove(10);
//            System.out.println(" jdkVector=" + jdkVector
//                    + " indexOf=" + jdkVector.indexOf(10)
//                    + " lastIndexOf=" + jdkVector.lastIndexOf(10));

            JDKStack jdkStack = new JDKStack();
            for (int i = 0; i < 30; i++) {
                jdkStack.push(i);
            }
            System.out.println("pop=" + jdkStack.pop()
                    + " jdkStack=" + jdkStack);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
