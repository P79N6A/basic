package com.itcast.basic.jdk.util.vector;

import java.util.Arrays;

/**
 * Created by treey.qian on 2018/3/21.
 */
public class JDKVector {

    protected Object[] elements = {};
    protected int size;
    protected int capacity;

    public JDKVector() {
        capacity = 16;
        elements = new Object[capacity];
    }

    public synchronized int capacity() {
        return capacity;
    }

    public synchronized int lastIndexOf(Object o) {
        int index = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(o)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public synchronized int indexOf(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public synchronized Object get(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("index is not valid");
        }
        return elements[index];
    }

    public synchronized boolean remove(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("index is not valid");
        }
        while (index < size - 1) {
            elements[index] = elements[index + 1];
            index++;
        }
        elements[--size] = null;
        return true;
    }

    public synchronized boolean remove(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            while (index < size - 1) {
                elements[index] = elements[index + 1];
                index++;
            }
            elements[--size] = null;
            return true;
        }
        return false;
    }

    public synchronized boolean add(Object o) {
        checkCapacity(size);
        elements[size++] = o;
        return true;
    }

    public synchronized boolean add(int index, Object o) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("index is not valid");
        }
        checkCapacity(size);
        int j = size - 1;
        while (j >= index) {
            elements[j + 1] = elements[j];
            j--;
        }
        elements[index] = o;
        size++;
        return true;
    }

    public synchronized boolean set(int index, Object o) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("index is not valid");
        }
        elements[index] = o;
        return true;
    }

    public synchronized boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }


    private void checkCapacity(int size) {
        if (size >= capacity) {
            while (size >= capacity) {
                capacity += capacity;
            }
            Object[] oldElements = elements;
            elements = new Object[capacity];
            System.arraycopy(oldElements, 0, elements, 0, oldElements.length);
        }
    }


    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized String toString() {
        return "JDKVector{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
