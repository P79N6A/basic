package com.itcast.basic.datastruct.dataqueue;

/**
 * Created by treey.qian on 2017/12/4.
 */
public class DataQueueClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DataQueueClient");
            DataQueue<Integer> dataQueue = new DataQueue();
            for (int i = 0; i < 20; i++) {
                dataQueue.enQueue(i + 1);
            }
            Integer result = dataQueue.deQueue();
            System.out.println("result is " + result);
            dataQueue.display();
        } catch (Exception e) {
            System.out.println("DataQueueClient error message is" + e);
        }
    }
}
