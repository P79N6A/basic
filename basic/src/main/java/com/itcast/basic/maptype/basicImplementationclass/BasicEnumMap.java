package com.itcast.basic.maptype.basicImplementationclass;

import com.itcast.basic.maptype.basicabstractmap.BasicAbstractMap;
import sun.misc.SharedSecrets;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by qfl on 16/4/30.
 */

public class BasicEnumMap<K extends Enum<K>, V> extends BasicAbstractMap<K, V> {

    private Class<K> keyType;
    private Object[] vals;
    private K[] keyUniverse;
    private int size;
    private static final Object NULL = new Object();

    public BasicEnumMap(Class<K> typeClass) {
        this.keyType = typeClass;
        keyUniverse = getKeyUniverse(typeClass);
        vals = new Object[keyUniverse.length];
    }


    private static <K extends Enum<K>> K[] getKeyUniverse(Class<K> keyType) {
        return SharedSecrets.getJavaLangAccess()
                .getEnumConstantsShared(keyType);
    }

    private void typeCheck(Object key) {
        Class typeClass = key.getClass();
        if (keyType != typeClass && typeClass.getSuperclass() != keyType)
            throw new ClassCastException(typeClass + " != " + keyType);
    }

    @Override
    public V put(K key, V value) {
        typeCheck(key);
        int index = key.ordinal();
        Object oldValue = vals[index];
        vals[index] = markNull(value);
        if (oldValue == null)
            size++;
        return unMarkNull(oldValue);
    }

    private Object markNull(Object v) {
        return v == null ? NULL : v;
    }

    private V unMarkNull(Object v) {
        return (V) (v == NULL ? null : v);
    }

    private boolean isVaild(Object k) {
        if (k == null)
            return false;
        Class keyClass = k.getClass();
        return keyClass == keyType || keyType.getSuperclass() == keyType;
    }

    @Override
    public V get(Object key) {
        return (isVaild(key) ? unMarkNull(vals[((Enum) key).ordinal()]) : null);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
    public V remove(Object key) {
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
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }
}
