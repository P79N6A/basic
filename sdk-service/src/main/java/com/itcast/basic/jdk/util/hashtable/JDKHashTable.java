package com.itcast.basic.jdk.util.hashtable;

/**
 * Created by qfl on 2018/3/21.
 */
public class JDKHashTable {
    private int size;
    private Node[] tables;
    private int capacity;

    public JDKHashTable() {
        capacity = 16;
        tables = new Node[capacity];
    }

    public synchronized Object put(Object key, Object value) {
        if (key == null) {
            return putNullKey(value);
        }
        return putKey(key, value);
    }

    private Object putNullKey(Object value) {
        Node h = tables[0];
        if (h == null) {
            tables[0] = new Node(null, value, null);
            size++;
            return null;
        }
        do {
            if (h.getKey() == null) {
                Object oldV = h.getValue();
                h.setValue(value);
                size++;
                return oldV;
            }
        } while (h != null && (h = h.next) != null);
        h.next = new Node(null, value, null);
        size++;
        return null;
    }

    private Object putKey(Object key, Object value) {
        int index = index(key);
        Node h = tables[index];
        if (h == null) {
            tables[index] = new Node(key, value, null);
            size++;
            return null;
        }
        do {
            if (key.equals(h.getKey())) {
                Object oldV = h.getValue();
                h.setValue(value);
                size++;
                return oldV;
            }
        } while (h != null && (h = h.next) != null);
        h.next = new Node(key, value, null);
        size++;
        return null;
    }

    private int index(Object key) {
        return hash(key) % capacity;
    }

    private int hash(Object key) {
        return key == null ? 0 : key.hashCode();
    }

    public synchronized int size() {
        return size;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
