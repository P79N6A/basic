package com.itcast.basic.maptype.basicImplementationclass;

import com.itcast.basic.maptype.basicabstractmap.BasicAbstractMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by qfl on 16/5/1.
 */

public class BasicTreeMap<K, V> extends BasicAbstractMap<K, V> {


    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> parent;
        Entry<K, V> left = null;
        Entry<K, V> right = null;

        Entry(K key, V value, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        V setValue(V value) {
            Object oldValue = this.value;
            this.value = value;
            return (V) oldValue;
        }

        V getValue() {
            return value;
        }

        K getKey() {
            return key;
        }



    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }
}
