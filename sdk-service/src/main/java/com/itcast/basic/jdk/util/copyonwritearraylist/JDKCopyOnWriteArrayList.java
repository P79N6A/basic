package com.itcast.basic.jdk.util.copyonwritearraylist;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qfl on 2018/3/31.
 */
public class JDKCopyOnWriteArrayList {
    private int size;
    private Object[] objects;
    private ReentrantLock lock = new ReentrantLock();

    public JDKCopyOnWriteArrayList() {
    }

    public boolean remove(Object o) {
        try {
            lock.lock();
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (o == objects[i] || (o != null && o.equals(objects[i]))) {
                    index = i;
                }
            }
            if (index != -1) {
                Object[] newObjs = new Object[--size];
                System.arraycopy(objects, 0, newObjs, 0, index);
                System.arraycopy(objects, index + 1, newObjs, index, size - index);
                objects = newObjs;
            }
            return index != -1;
        } finally {
            lock.unlock();
        }
    }

    public boolean remove(int index) {
        try {
            lock.lock();
            assert 0 <= index && index < size;
            Object[] newObjs = new Object[--size];
            for (int i = 0, j = 0; i < size; i++) {
                if (i != index) {
                    newObjs[j++] = objects[i];
                }
            }
            objects = newObjs;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public boolean add(Object o) {
        try {
            lock.lock();
            Object[] old = objects;
            objects = new Object[size + 1];
            System.arraycopy(old, 0, objects, 0, old.length);
            objects[size++] = o;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public boolean add(int index, Object o) {
        try {
            lock.lock();
            assert index >= 0;
            Object[] newObjs = new Object[++size];
            int i = size - index;
            if (i == 0) {
                System.arraycopy(objects, 0, newObjs, 0, size);
            } else {
                System.arraycopy(objects, 0, newObjs, 0, index);
                System.arraycopy(objects, index, newObjs, index + 1, i);
            }
            newObjs[index] = o;
            objects = newObjs;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public boolean set(int index, Object o) {
        try {
            lock.lock();
            assert index >= 0;
            Object[] newObjs = new Object[size];
            System.arraycopy(objects, 0, newObjs, 0, size);
            newObjs[index] = o;
            objects = newObjs;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public int indexOf(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (o == objects[i] || (o != null && o.equals(objects[i]))) {
                index = i;
            }
        }
        return index;
    }

    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (o == objects[i] || (o != null && o.equals(objects[i]))) {
                index = i;
            }
        }
        return index;
    }


    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == objects[i] || (o != null && o.equals(objects[i]))) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
}
