package com.itcast.basic.jdk.util.enummap;

/**
 * Created by treey.qian on 2018/3/22.
 */
public class JDKEnumMap<K extends Enum> {
    private K key;
    private Class keyType;
    private Object[] tabs = {};
    private int capacity;
    private int size;
    private final Object NULL = new Object() {
        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String toString() {
            return "this is NULL Object";
        }
    };

    private Object makeNULL(Object value) {
        return value == null ? NULL : value;
    }

    private Object unMakeNULL(Object value) {
        return value == NULL ? null : value;
    }

    public JDKEnumMap(Class keyType) {
        this.keyType = keyType;
        capacity = 16;
        tabs = new Object[capacity];
    }

    private void checkType(K key) {
        Class type = key.getClass();
        if (type != keyType && type.getClass() != keyType) {
            throw new ClassCastException(type + " != " + keyType);
        }
    }

    public Object put(K key, Object value) {
        checkType(key);
        int index = key.ordinal();
        checkCapacity(index);
        Object oldV = tabs[index];
        tabs[index] = makeNULL(value);
        return unMakeNULL(oldV);
    }

    public Object get(K key) {
        checkType(key);
        int index = key.ordinal();
        if (index < 0 && index >= size) {
            return null;
        }
        return unMakeNULL(tabs[index]);
    }

    private void checkCapacity(int size) {
        if (size >= capacity) {
            while (size >= capacity) {
                capacity += capacity;
            }
            Object[] old = tabs;
            tabs = new Object[capacity];
            System.arraycopy(old, 0, tabs, 0, old.length);
        }
    }


}
