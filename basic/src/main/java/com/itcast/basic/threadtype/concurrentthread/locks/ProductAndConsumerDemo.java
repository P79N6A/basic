package com.itcast.basic.threadtype.concurrentthread.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qfl on 16/4/23.
 */
public class ProductAndConsumerDemo {
    public static void main(String[] args) {
        final ProductAndConsumer productAndConsumer = new ProductAndConsumer(100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                productAndConsumer.consumer();
            }
        }).start();

        productAndConsumer.product();
    }
}

class ProductAndConsumer {

    private int queueSize;
    private ReentrantLock lock = new ReentrantLock();
    private Condition productCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();

    public ProductAndConsumer(int size) {
        queueSize = size;
    }

    public void product() {
        while (true)
            try {
                lock.lock();
                while (queueSize > 0)
                    productCondition.await();
                queueSize++;
                System.out.println("生成者被调用");
                consumerCondition.signal();
                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void consumer() {
        while (true)
            try {
                lock.lock();
                while (queueSize <= 0)
                    consumerCondition.await();
                queueSize--;
                System.out.println("消费者被调用");
                productCondition.signal();
                lock.unlock();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
