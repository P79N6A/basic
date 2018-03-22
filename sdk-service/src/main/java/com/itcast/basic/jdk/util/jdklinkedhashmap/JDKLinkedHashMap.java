package com.itcast.basic.jdk.util.jdklinkedhashmap;

import com.itcast.basic.jdk.util.hashmap.JDKHashMap;

/**
 * Created by treey.qian on 2018/3/22.
 */
public class JDKLinkedHashMap extends JDKHashMap {
    private Node head;
    private Node tail;

    public JDKLinkedHashMap() {

    }

    protected void addEntry(Object key, Object value) {
        Node l = tail, node = new Node(key, value, null);
        tail = node;
        if (l == null) {
            head = tail;
            return;
        }

        Node h = head;
        while (h != null) {
            if (h.getKey() == key || (key != null && key.equals(h.getKey()))) {
                h.setValue(value);
                return;
            }
            h = h.getNext();
        }

        l.setNext(node);
    }

    public Object get(Object key) {
        Node h = head;
        while (h != null) {
            if (h.getKey() == key || (key != null && key.equals(h.getKey()))) {
                return h.getValue();
            }
            h = h.getNext();
        }
        return null;
    }

    public boolean containValue(Object value) {
        Node h = head;
        while (h != null) {
            if (h.getValue() == value || (value != null && value.equals(h.getValue()))) {
                return true;
            }
            h = h.getNext();
        }
        return false;
    }

    protected void removeEntry(Object key) {
        Node h = head, prev = null;
        while (h != null) {
            if (h.getKey() == key || (key != null && key.equals(h.getKey()))) {
                if (prev == null) {
                    head = h.getNext();
                } else {
                    prev.setNext(h.getNext());
                }
                h.setNext(null);
                return;
            }
            prev = h;
            h = h.getNext();
        }
    }
}
