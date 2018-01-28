package com.itcast.basic.collectiontype.impletmentclass;

import java.util.Arrays;

/**
 * Created by qfl on 16/5/1.
 */
public class BasicArrayList<E> {
    private static final Object[] EMPT = {};
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_SIZE = 10;
    private int modCount;

    public BasicArrayList(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("参数异常");
        elementData = new Object[capacity];
    }

    public BasicArrayList() {
        this.elementData = EMPT;
    }

    public boolean add(E e) {
        entrueCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    private void entrueCapacity(int toSize) {
        if (elementData == EMPT)
            toSize = Math.min(DEFAULT_SIZE, toSize);
        ensureExplicitCapacity(toSize);
    }

    private void ensureExplicitCapacity(int toSize) {
        modCount++;
        if (toSize > elementData.length)
            grow(toSize);
    }

    private void grow(int capacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public boolean add(int index, E e) {
        rangForIndex(index);
        entrueCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = e;
        size++;
        return true;
    }

    public E set(int index, E e) {
        rangForIndex(index);
        E oldValue = elementData(index);
        elementData[index] = e;
        return oldValue;
    }

    public E get(int index) {
        rangForIndex(index);
        return elementData(index);
    }

    private E elementData(int index) {
        return (E) elementData[index];
    }

    private void rangForIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("数组下标越界");
    }

}
