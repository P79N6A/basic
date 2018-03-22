package com.itcast.basic.jdk.util.hashset;

import com.itcast.basic.jdk.util.hashmap.JDKHashMap;

/**
 * Created by treey.qian on 2018/3/22.
 */
public class JDKHashSet {

    private JDKHashMap jdkHashMap;
    private final Object instance = new Object();

    public JDKHashSet() {
        jdkHashMap = new JDKHashMap();
    }

    public boolean add(Object o) {
        return jdkHashMap.put(o, instance) == null;
    }

    public boolean contains(Object o) {
        return jdkHashMap.containsKey(o);
    }

    public boolean remove(Object o) {
        return jdkHashMap.remove(o) == instance;
    }

    public int size() {
        return jdkHashMap.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[ ");
        int capacity = jdkHashMap.capacity();
        int size = jdkHashMap.size();
        JDKHashMap.Node[] tables = jdkHashMap.tables();
        for (int i = 0; i < capacity; i++) {
            JDKHashMap.Node h = tables[i];
            while (h != null) {
                stringBuilder.append(h.getKey()).append(" ");
                h = h.getNext();
            }
        }
        stringBuilder.append(" ]");
        return "JDKHashMap{" +
                "capacity=" + capacity +
                ", size=" + size +
                ", tables=" + stringBuilder +
                '}';
    }
}
