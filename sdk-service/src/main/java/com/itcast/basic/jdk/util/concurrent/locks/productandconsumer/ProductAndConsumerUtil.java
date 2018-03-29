package com.itcast.basic.jdk.util.concurrent.locks.productandconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class ProductAndConsumerUtil {
    private int queueSize;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition produce = lock.newCondition();
    private final Condition consumer = lock.newCondition();

    public ProductAndConsumerUtil(int queueSize) {
        this.queueSize = queueSize;
    }

    //生产者
    public void produce() throws InterruptedException {
        while (true) {
            lock.lock();
            while (queueSize > 0) {
                produce.await();
            }
            System.out.println("生产者生产" + (++queueSize));
            consumer.signal();
            lock.unlock();
        }
    }

    //消费者
    public void consume() throws InterruptedException {
        while (true) {
            lock.lock();
            while (queueSize <= 0) {
                consumer.await();
            }

            System.out.println("消费者消费" + (--queueSize));
            produce.signal();
            lock.unlock();
        }
    }
}
