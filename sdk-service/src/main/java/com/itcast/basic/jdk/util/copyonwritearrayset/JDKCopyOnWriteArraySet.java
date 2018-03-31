package com.itcast.basic.jdk.util.copyonwritearrayset;

import com.itcast.basic.jdk.util.copyonwritearraylist.JDKCopyOnWriteArrayList;

/**
 * Created by qfl on 2018/3/31.
 */
public class JDKCopyOnWriteArraySet {
    private JDKCopyOnWriteArrayList jdkCopyOnWriteArrayList;

    public JDKCopyOnWriteArraySet() {
        this.jdkCopyOnWriteArrayList = new JDKCopyOnWriteArrayList();
    }

    public boolean add(Object o) {
        return jdkCopyOnWriteArrayList.indexOf(o) != -1 ? false : jdkCopyOnWriteArrayList.add(o);
    }

    public boolean add(int index, Object o) {
        return jdkCopyOnWriteArrayList.indexOf(o) != -1 ? false : jdkCopyOnWriteArrayList.add(index, o);
    }

    public boolean remove(Object o) {
        return jdkCopyOnWriteArrayList.remove(o);
    }

    public boolean contains(Object o) {
        return jdkCopyOnWriteArrayList.contains(o);
    }

    public int size() {
        return jdkCopyOnWriteArrayList.size();
    }

}
