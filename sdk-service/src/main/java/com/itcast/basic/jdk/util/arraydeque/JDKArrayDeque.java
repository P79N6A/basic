package com.itcast.basic.jdk.util.arraydeque;

import java.util.Arrays;

/**
 * Created by treey.qian on 2018/3/22.
 */
public class JDKArrayDeque {

    private int size;
    private int capacity;
    private Object[] objects = {};

    private int head;
    private int tail;

    public JDKArrayDeque() {
        capacity = 16;
        objects = new Object[capacity];
    }

    public boolean add(Object value) {
        checkCapacity();
        tail = size;
        objects[size++] = value;
        return true;
    }

    public boolean push(Object value) {
        checkCapacity();
        tail = size;
        objects[size++] = value;
        return true;
    }

    public Object pop() {
        Object obj = objects[tail];
        objects[tail--] = null;
        size--;
        return obj;
    }

    private void checkCapacity() {
        if (size >= capacity) {
            while (size >= capacity) {
                capacity *= 2;
            }
            Object[] old = objects;
            objects = new Object[capacity];
            System.arraycopy(old, 0, objects, 0, old.length);
        }
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return size;
    } 

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "JDKArrayDeque{" +
                "size=" + size +
                ", capacity=" + capacity +
                ", objects=" + Arrays.toString(objects) +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
