package com.itcast.basic.jdk.util.arrayblockingqueue;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by treey.qian on 2018/3/30.
 */
public class JDKArrayBlockingQueue {
    private int size;
    private int capacity;
    private Object[] objects;
    private ReentrantLock lock;
    private Condition full;
    private Condition empty;

    public JDKArrayBlockingQueue() {
        capacity = 16;
        objects = new Object[capacity];
        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
    }


    public boolean put(Object o) throws InterruptedException {
        try {
            lock.lock();
            while (objects.length == size) {
                full.await();
            }
            objects[size++] = o;
            empty.signal();
        } finally {
            lock.unlock();
        }
        return true;
    }


    public boolean offer(Object o) {
        try {
            lock.lock();
            if (objects.length == size) {
                return false;
            } else {
                objects[size++] = o;
                empty.signal();
                return true;
            }
        } finally {
            lock.unlock();
        }
    }

    public Object poll() {
        try {
            lock.lock();
            Object o = objects[0];
            for (int i = 0; i < size - 1; i++) {
                objects[i] = objects[i + 1];
            }
            objects[size--] = null;
            full.signal();
            return o;
        } finally {
            lock.unlock();
        }
    }


    public Object take() throws InterruptedException {
        try {
            lock.lock();
            while (size == 0) {
                empty.await();
            }
            Object o = objects[0];
            for (int i = 0; i < size - 1; i++) {
                objects[i] = objects[i + 1];
            }
            objects[size--] = null;
            full.signal();
            return o;
        } finally {
            lock.unlock();
        }
    }

    public Object peek() {
        try {
            lock.lock();
            return size == 0 ? null : objects[0];
        } finally {
            lock.unlock();
        }
    }

    public boolean add(Object o) {
        return offer(o);
    }

    private void checkCapacity() {
        if (size >= capacity) {
            while (size >= capacity) {
                capacity += capacity;
            }
            Object[] old = objects;
            objects = new Object[capacity];
            System.arraycopy(old, 0, objects, 0, old.length);
        }
    }


    public boolean remove(Object o) {
        try {
            lock.lock();
            boolean isSuccess = false;
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (o == objects[i] || (o != null && o.equals(objects[i]))) {
                    index = i;
                    isSuccess = true;
                    break;
                }
            }
            if (index != -1) {
                while (index < size - 1) {
                    objects[index] = objects[index + 1];
                    index++;
                }
                objects[--size] = null;
            }
            return isSuccess;
        } finally {
            lock.unlock();
        }
    }

    public boolean contains(Object o) {
        try {
            lock.lock();
            for (int i = 0; i < size; i++) {
                if (o == objects[i] || (o != null && o.equals(objects[i]))) {
                    return true;
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        try {
            lock.lock();
            return size;
        } finally {
            lock.unlock();
        }
    }

    public int capacity() {
        try {
            lock.lock();
            return capacity;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "JDKArrayBlockingQueue{" +
                "size=" + size +
                ", capacity=" + capacity +
                ", objects=" + Arrays.toString(objects) +
                '}';
    }
}
