package com.itcast.basic.datastruct.dataqueue;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/12/4.
 * this is a queue struct class
 */
public class DataQueue<T> implements Serializable {

    private Object[] data;

    private transient int capacity = 20;

    private transient double percent = 0.75;

    private int size;

    public DataQueue() {
        data = new Object[capacity];
    }

    private synchronized boolean changeCapacity() {
        boolean isSuccess = true;
        try {
            capacity = (int) (capacity * (1 + percent)) + 1;
        } catch (Exception e) {
            System.out.println("changeCapacity error message is" + e);
            isSuccess = false;
        }
        return isSuccess;
    }

    public synchronized boolean enQueue(T element) {
        if (element == null) {
            throw new IllegalArgumentException("element is valid");
        }
        boolean isSuccess = true;
        int length = data.length;
        try {
            if (size >= length) {
                boolean isEx = changeCapacity();
                if (isEx) {
                    Object[] oldData = data;
                    data = new Object[capacity];
                    for (int i = 0; i < length; i++) {
                        data[i] = oldData[i];
                    }
                    data[size++] = element;
                } else {
                    return false;
                }
            } else {
                data[size++] = element;
            }
        } catch (Exception e) {
            System.out.println("enQueue error message is" + e);
        }
        return isSuccess;
    }

    public synchronized T deQueue() {
        if (size == 0) {
            throw new IllegalArgumentException("队列中不含任何元素出队失败");
        }
        Object result = data[0];
        size--;
        int len = data.length;
        Object[] oldData = data;
        data = new Object[capacity];
        for (int i = 1, j = 0; i < len; i++) {
            data[j++] = oldData[i];
        }
        return (T) result;
    }

    public int size() {
        return size;
    }

    public synchronized String toString() {
        StringBuilder stringBuilder = new StringBuilder("queue elements is { ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(" ").append(data[i]).append(" ");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public synchronized void display() {
        StringBuilder stringBuilder = new StringBuilder("queue elements is { ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(i).append(" ====> ").append(data[i]).append(" ");
        }
        stringBuilder.append(" }");
        System.out.println(stringBuilder.toString());
    }

}
