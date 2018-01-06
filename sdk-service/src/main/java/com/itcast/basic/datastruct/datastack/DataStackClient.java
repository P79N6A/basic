package com.itcast.basic.datastruct.datastack;

/**
 * Created by treey.qian on 2017/12/5.
 */
public class DataStackClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DataStackClient");
            DataStack<Integer> dataStack = new DataStack();
            for (int i = 0; i < 30; i++) {
                dataStack.push(i);
            }
            dataStack.display();
            System.out.println("result is " + dataStack.pop());
            dataStack.display();
        } catch (Exception e) {
            System.out.println("DataStackClient error message is" + e);
        }
    }
}
