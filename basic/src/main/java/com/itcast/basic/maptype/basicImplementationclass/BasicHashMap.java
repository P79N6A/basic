package com.itcast.basic.maptype.basicImplementationclass;

import com.itcast.basic.maptype.basicabstractmap.BasicAbstractMap;
import com.itcast.basic.maptype.basicinterface.BasicMap;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/*
*
        *Created by qfl on 16/4/30.
*/


public class BasicHashMap<K, V> extends BasicAbstractMap implements Serializable, Cloneable {


    private static final float LOADFACTOR = 0.75f;
    private static final int CAPACITY = 1 << 4;
    private static final int BIGNUMBER = 1 << 30;
    private static final BasicHashMap.Entry[] EMPTY_TABLE = {};
    private static BasicHashMap.Entry[] tables = EMPTY_TABLE;
    private float loadFactor;
    private int capacity;
    private int size;
    private int modeNum;
    private transient int hashSeed = 0;
    private int threshold;

    public BasicHashMap() {
        this(CAPACITY, LOADFACTOR);
    }

    public BasicHashMap(int capacity) {
        this(capacity, LOADFACTOR);
    }

    public BasicHashMap(int capacity, float loadFactor) {
        if (capacity < 0)
            throw new IllegalArgumentException("参数异常");
        if (capacity > BIGNUMBER)
            capacity = BIGNUMBER;
        if (loadFactor < 0 && Float.isNaN(loadFactor))
            throw new IllegalArgumentException("参数异常");
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        init();
    }

    void init() {
    }

    static class Entry<K, V> implements BasicMap.Entry<K, V> {

        K key;
        V value;
        int hash;
        BasicHashMap.Entry next;

        Entry(K key, V value, BasicHashMap.Entry next, int hash) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public final V getValue() {
            return value;
        }

        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {

            if (!(o instanceof Entry))
                return false;
            BasicHashMap.Entry entry = (BasicHashMap.Entry) o;
            Object k1 = entry.getKey();
            Object k2 = getKey();
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = entry.getValue();
                if (v1 == v1 || (v1 != null && v1.equals(v2)))
                    return true;
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }

        void recordAccess(BasicHashMap<K, V> m) {
        }

        void recordRemoval(BasicHashMap<K, V> m) {
        }
    }

    private int capacity() {
        return capacity;
    }

    private float loadFactor() {
        return loadFactor;
    }

    private int hash(Object k) {
        int h = hashSeed;
        if (0 != h && k instanceof String) {
            return sun.misc.Hashing.stringHash32((String) k);
        }
        h ^= k.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int indexFor(int h, int length) {
        return h & (length - 1);
    }

    private void initTable(int toSize) {
        int capacity = toSize >= BIGNUMBER ? BIGNUMBER : (toSize < 0 ? CAPACITY : toSize);
        tables = new Entry[capacity];
        threshold = (int) Math.min(capacity * loadFactor, BIGNUMBER + 1);
    }

    private void creatEntry(int hash, Object key, Object value, int index) {
        BasicHashMap.Entry old = tables[index];
        BasicHashMap.Entry newEntry = new Entry(key, value, old, hash);
        tables[index] = newEntry;
        modeNum++;
    }

    private void addEntry(int hash, Object key, Object value, int index) {
        if (size >= capacity && tables[index] != null) {
            resize(tables.length * 2);
            hash = hash(key);
            index = indexFor(hash, tables.length);
        }
        creatEntry(hash, key, value, index);
    }

    private void resize(int toSize) {
        BasicHashMap.Entry[] oldTable = tables;
        tables = new BasicHashMap.Entry[toSize];
        tranfor(oldTable, tables);
        threshold = (int) Math.min(capacity * loadFactor, BIGNUMBER + 1);
    }

    private void tranfor(BasicHashMap.Entry[] oldTable, BasicHashMap.Entry[] newTable) {
        for (BasicHashMap.Entry entry : oldTable) {
            while (entry != null) {
                int hash = hash(entry.getKey());
                int index = indexFor(hash, newTable.length);
                newTable[index] = entry;
                //释放对象
                entry.next = null;
                entry = null;
            }
        }
    }

    @Override
    public Object put(Object key, Object value) {
        if (tables == EMPTY_TABLE) {
            initTable(CAPACITY);
        }
        if (key == null)
            putNullValue(value);
        int hash = hash(key.hashCode());
        int index = indexFor(hash, tables.length);

        for (BasicHashMap.Entry entry = tables[index]; entry != null; entry = entry.next) {
            Object k = (Object) entry.getKey();
            if (k == key || (k != null && k.equals(key))) {
                Object oldValue = (Object) entry.getValue();
                entry.recordAccess(this);
                entry.setValue(value);
                return oldValue;
            }
        }
        modeNum++;
        addEntry(hash, key, value, index);
        return null;
    }

    private Object putNullValue(Object value) {
        for (BasicHashMap.Entry entry = tables[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                Object oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }
        modeNum++;
        addEntry(0, null, value, 0);
        return null;
    }

    private Object getNullValue() {

        if (size == 0)
            return null;

        for (BasicHashMap.Entry entry = tables[0]; entry != null; entry = entry.next) {
            if (entry.getValue() == null)
                return entry.getValue();
        }
        return null;
    }

    private BasicHashMap.Entry getEntry(Object key) {
        if (size == 0)
            return null;
        int hash = key == null ? 0 : hash(key);
        int index = indexFor(hash, tables.length);
        for (BasicHashMap.Entry entry = tables[index]; entry != null; entry = entry.next) {
            Object k;
            if (entry.hash == hash && ((k = entry.getKey()) == key || (key != null && key.equals(k)))) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public Object get(Object key) {
        if (key == null)
            return getNullValue();
        BasicHashMap.Entry entry = getEntry(key);
        return entry == null ? null : entry.getValue();
    }

    private boolean containsNullValue(Object value) {
        for (BasicHashMap.Entry entry : tables)
            for (; entry != null; entry = entry.next)
                if (entry.getValue() == null)
                    return true;
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null)
            return containsNullValue(value);
        for (BasicHashMap.Entry entry : tables)
            for (; entry != null; entry = entry.next)
                if (value.equals(entry.getValue()))
                    return true;
        return false;
    }

    @Override
    public boolean containsKey(Object key) {

        return getEntry(key) == null;
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
    public Set<Entry> entrySet() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
