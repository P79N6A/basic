package com.itcast.basic.jdk.util.identityhashmap;

/**
 * Created by treey.qian on 2018/3/22.
 */
public class JDKIdentityHashMap {

    private Object[] tables = {};
    private int size;
    private int capacity;

    public JDKIdentityHashMap() {
        capacity = 16;
        tables = new Object[capacity];
    }

    public Object put(Object key, Object value) {
        checkCapacity();
        int index;
        for (int i = 0; i < size; i++) {
            index = i * 2;
            if (tables[index] == key) {
                Object old = tables[index + 1];
                tables[index + 1] = value;
                return old;
            }
        }
        index = size * 2;
        tables[index] = key;
        tables[index + 1] = value;
        size++;
        return null;
    }

    public Object remove(Object key) {
        for (int i = 0; i < size; i++) {
            int index = i * 2;
            if (tables[index] == key) {
                Object oldV = tables[index + 1];
                int k = i;
                while (k < size - 1) {
                    int m = k * 2;
                    int l = (k + 1) * 2;
                    tables[m] = tables[l];
                    tables[m + 1] = tables[l + 1];
                    k++;
                }
                size--;
                return oldV;
            }
        }
        return null;
    }

    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            int index = i * 2;
            if (tables[index] == key) {
                return tables[index + 1];
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (tables[i * 2] == key) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (int i = 0; i < size; i++) {
            if (tables[i * 2 + 1] == value) {
                return true;
            }
        }
        return false;
    }

    private void checkCapacity() {
        if (size >= capacity / 2) {
            while (size >= capacity / 2) {
                capacity *= 2;
            }
            Object[] old = tables;
            tables = new Object[capacity];
            System.arraycopy(old, 0, tables, 0, old.length);
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
        StringBuilder stringBuilder = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(tables[i * 2 + 1]).append(" ");
        }
        stringBuilder.append(" ]");
        return "JDKIdentityHashMap{" +
                "tables=" + stringBuilder +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }


}
