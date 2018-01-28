package com.itcast.basic.collectiontype.impletmentclass;

import com.itcast.basic.maptype.basicImplementationclass.BasicHashMap;

/**
 * Created by qfl on 16/5/1.
 */
public class BasicHashSet<K> {

    private final Object INSTANT = new Object();
    private BasicHashMap map;

    public BasicHashSet() {
        map = new BasicHashMap();
    }

    public BasicHashSet(int capacity) {
        map = new BasicHashMap(capacity);
    }

    public BasicHashSet(int capacity, float loadFactor) {
        map = new BasicHashMap(capacity, loadFactor);
    }

    public boolean add(K key) {
        return map.put(key, INSTANT) == null;
    }

    public boolean remove(K key) {
        return map.remove(key) == INSTANT;
    }
}
