package com.itcast.basic.jdk.util.collection;

import java.util.Arrays;

/**
 * Created by treey.qian on 2018/3/20.
 */
public class JDKArrayList {
    private Object[] elements = {};

    private int size;

    private int capacity;

    public JDKArrayList() {
        capacity = 16;
        elements = new Object[capacity];
    }

    public boolean add(Object o) {
        checkCapacity(size);
        elements[size++] = o;
        return true;
    }

    public boolean set(int index, Object o) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index is not valid");
        }
        elements[index] = o;
        return true;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(o)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int indexOf(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean remove(int index) {
        System.out.println("**************");
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index is not valid");
        }

        while (index < size - 1) {
            elements[index] = elements[index + 1];
            index++;
        }
        elements[--size] = null;
        return true;
    }


    public boolean remove(Object o) {
        int index = -1;
        System.out.println("--------------");
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

    public boolean add(int index, Object o) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index is not valid");
        }
        checkCapacity(size);
        int k = size - 1;
        while (index <= k) {
            elements[k + 1] = elements[k];
            k--;
        }
        elements[index] = o;
        size++;
        return true;
    }

    public Object get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index is not valid");
        }
        return elements[index];
    }


    private void checkCapacity(int size) {
        if (capacity <= size) {
            while (capacity <= size) {
                capacity += capacity;
            }
            Object[] oldElements = elements;
            elements = new Object[capacity];
            System.arraycopy(oldElements, 0, elements, 0, size);
        }

    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "JDKArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
