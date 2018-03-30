package com.itcast.basic.jdk.util.delayqueue;

import com.itcast.basic.jdk.util.priorityqueue.JDKPriorityQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class JDKDelayQueue<E extends Delayed> {

    private Thread leader;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private JDKPriorityQueue p = new JDKPriorityQueue();

    public JDKDelayQueue() {

    }

    public boolean add(E e) {
        return offer(e);
    }

    public boolean put(E e) {
        return offer(e);
    }

    public Object poll() {
        try {
            lock.lock();
            Delayed o = (Delayed) p.peek();
            if (o == null || o.getDelay(NANOSECONDS) > 0) {
                return null;
            } else {
                return p.poll();
            }
        } finally {
            lock.unlock();
        }
    }

    public Object peek() {
        try {
            lock.lock();
            return p.peek();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        try {
            lock.lock();
            return p.size();
        } finally {
            lock.unlock();
        }
    }

    private boolean offer(E e) {
        lock.lock();
        boolean isSuccess = p.add(e);
        if (p.peek() == e) {
            leader = null;//防止take方法情况(2)出现导致死锁
            condition.signal();
        }
        lock.unlock();
        return isSuccess;
    }

    public Object take() throws InterruptedException {
        try {
            lock.lockInterruptibly();
            while (true) {
                Object o = p.peek();
                if (o == null) {
                    condition.await();//(1)
                } else {
                    Delayed delayed = (Delayed) o;
                    long time = delayed.getDelay(NANOSECONDS);
                    if (time <= 0) {
                        return p.poll();//(4)
                    }
                    o = null;
                    if (leader != null) {
                        condition.await();//(2)
                    } else {
                        Thread one = Thread.currentThread();
                        leader = one;
                        try {
                            condition.awaitNanos(time);//(3)
                        } finally {
                            if (one == leader) {
                                leader = null;
                            }
                        }
                    }
                }
            }
        } finally {
            //(1) (2) (3)发生异常 (4)返回时 均能运行该方法
            if (leader == null && p.peek() != null) {//筛选(3) (4)
                //符合情况 (3) (4) 可进入此方法
                condition.signal();
            }
            lock.unlock();
        }

    }
}
