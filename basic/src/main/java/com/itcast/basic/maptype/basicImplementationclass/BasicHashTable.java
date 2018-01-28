package com.itcast.basic.maptype.basicImplementationclass;

import com.itcast.basic.maptype.basicabstractmap.BasicAbstractMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by qfl on 16/4/30.
 */
public class BasicHashTable extends BasicAbstractMap {
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
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Map.Entry> entrySet() {
        return null;
    }
}
