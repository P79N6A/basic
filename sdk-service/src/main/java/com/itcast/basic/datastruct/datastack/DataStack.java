package com.itcast.basic.datastruct.datastack;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/12/5.
 */
public class DataStack<T> implements Serializable {

    private Object[] data;

    private transient int capacity = 20;

    private transient double percent = 0.75;

    private int size;

    public DataStack() {
        data = new Object[capacity];
    }

    private synchronized boolean changeCapacity() {
        boolean isSuccess = true;
        try {
            capacity = (int) (capacity * (percent + 1));
        } catch (Exception e) {
            isSuccess = false;
            System.out.println("changeCapacity error message is" + e);
        }
        return isSuccess;
    }

    public synchronized boolean push(T element) {
        if (element == null) {
            throw new IllegalArgumentException("element is not valid");
        }
        boolean isSuccess = true;
        int len = data.length;
        try {
            if (size >= len) {
                boolean isEx = changeCapacity();
                if (isEx) {
                    Object[] oldData = data;
                    data = new Object[capacity];
                    for (int i = 0; i < len; i++) {
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
            isSuccess = false;
            System.out.println("push error message is" + e);
        }
        return isSuccess;
    }

    public synchronized T pop() {
        if (size == 0) {
            throw new IllegalArgumentException("堆栈中不含任何元素出队失败");
        }
        Object result = data[size--];
        Object[] oldData = data;
        data = new Object[capacity];
        for (int i = 0; i < size; i++) {
            data[i] = oldData[i];
        }
        return (T) result;
    }

    public synchronized String toString() {
        StringBuilder stringBuilder = new StringBuilder("stack elements is { ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]).append(" ");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public synchronized void display() {
        StringBuilder stringBuilder = new StringBuilder("stack elements is { ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(i).append(" ====> ").append(data[i]).append(" ");
        }
        stringBuilder.append(" }");
        System.out.println(stringBuilder.toString());
    }

    public int size() {
        return size;
    }
}
