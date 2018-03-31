package com.itcast.basic.jdk.util.priorityqueue;

import java.util.Arrays;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class JDKPriorityQueue {
    private Object[] queue;
    private int capacity;
    private int size;

    public JDKPriorityQueue() {
        capacity = 16;
        queue = new Object[capacity];
    }

    public boolean add(Object e) {
        if (e == null) {
            throw new NullPointerException("e is not null");
        }
        if (!(e instanceof Comparable)) {
            throw new NullPointerException("e is not Comparable instance");
        }
        if (size == 0) {
            queue[size++] = e;
        } else {
            checkCapacity();
            //插入排序
            Comparable comparable = (Comparable) e;
            int i = size - 1;
            while (i >= 0 && comparable.compareTo(queue[i]) > 0) {
                queue[i + 1] = queue[i];
                i--;
            }
            queue[i + 1] = e;
            size++;
        }
        return true;
    }


    public Object poll() {
        if (size == 0) {
            return null;
        }
        int index = --size;
        for (int i = 0; i < index; i++) {
            queue[i] = queue[i + 1];
        }
        Object old = queue[index];
        queue[index] = null;
        return old;
    }

    public Object peek() {
        return size == 0 ? null : queue[0];
    }

    public boolean remove(Object e) {
        if (e == null) {
            throw new NullPointerException("e is not null");
        }
        if (!(e instanceof Comparable)) {
            throw new NullPointerException("e is not Comparable instance");
        }
        Comparable comparable = (Comparable) e;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (comparable.compareTo(queue[i]) == 0) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            while (index < size) {
                queue[index] = queue[index + 1];
                index++;
            }
            queue[--size] = null;
        }
        return false;
    }

    public boolean contains(Object e) {
        if (e == null) {
            throw new NullPointerException("e is not null");
        }
        if (!(e instanceof Comparable)) {
            throw new NullPointerException("e is not Comparable instance");
        }
        Comparable comparable = (Comparable) e;
        for (int i = 0; i < size; i++) {
            if (comparable.compareTo(queue[i]) == 0) {
                return true;
            }
        }
        return false;
    }


    private void checkCapacity() {
        if (size >= capacity) {
            while (size >= capacity) {
                capacity += capacity;
            }
            Object[] old = queue;
            queue = new Object[capacity];
            System.arraycopy(old, 0, queue, 0, old.length);
        }

    }

    public int size() {
        return size;
    }

    private int capacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "JDKPriorityQueue{" +
                "queue=" + Arrays.toString(queue) +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}
