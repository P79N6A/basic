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

    protected Node[] tables() {
        return tables;
    }

    public synchronized boolean containKey(Object key) {
        for (int i = 0; i < capacity; i++) {
            Node h = tables[i];
            while (h != null) {
                if (key == null) {
                    if (h.getKey() == null) {
                        return true;
                    }
                } else {
                    if (key.equals(h.getKey())) {
                        return true;
                    }
                }
                h = h.next;
            }
        }
        return false;
    }

    public synchronized boolean containsValue(Object value) {
        for (int i = 0; i < capacity; i++) {
            Node h = tables[i];
            while (h != null) {
                if (value == null) {
                    if (h.getValue() == null) {
                        return true;
                    }
                } else {
                    if (value.equals(h.getValue())) {
                        return true;
                    }
                }
                h = h.next;
            }
        }
        return false;
    }


    public synchronized Object remove(Object key) {
        if (key == null) {
            return removeNullValue(key);
        }
        return removeValue(key);
    }

    private Object removeNullValue(Object key) {
        Node h = tables[0], prev = null;
        while (h != null) {
            if (h.getKey() == null) {
                Object oldV = h.getValue();
                if (prev == null) {
                    tables[0] = h.next;
                } else {
                    prev.next = h.next;
                }
                size--;
                return oldV;
            }
            h.next = null;
            prev = h;
            h = h.next;
        }
        return null;
    }

    private Object removeValue(Object key) {
        int index = index(key);
        Node h = tables[index], prev = null;
        while (h != null) {
            if (key.equals(h.getKey())) {
                Object oldV = h.getValue();
                if (prev == null) {
                    tables[index] = h.next;
                } else {
                    prev.next = h.next;
                }
                size--;
                return oldV;
            }
            h.next = null;
            prev = h;
            h = h.next;
        }
        return null;
    }

    public synchronized Object get(Object key) {
        if (key == null) {
            return getNullValue(key);
        }
        return getValue(key);
    }

    private Object getNullValue(Object key) {
        Node h = tables[0];
        while (h != null) {
            if (h.getKey() == null) {
                return h.getValue();
            }
            h = h.next;
        }
        return null;
    }

    private Object getValue(Object key) {
        int index = index(key);
        Node h = tables[index];
        while (h != null) {
            if (key.equals(h.getKey())) {
                return h.getValue();
            }
            h = h.next;
        }
        return null;
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
                return oldV;
            }
        } while (h.next != null && (h = h.next) != null);
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
                return oldV;
            }
        } while (h.next != null && (h = h.next) != null);

        h.next = new Node(key, value, null);
        size++;
        return null;
    }

    private int index(Object key) {
        return Math.abs(hash(key) % capacity);
    }

    private int hash(Object key) {
        return key == null ? 0 : key.hashCode();
    }

    public synchronized int size() {
        return size;
    }

    public synchronized int capacity() {
        return capacity;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[ ");
        for (int i = 0; i < capacity; i++) {
            Node h = tables[i];
            while (h != null) {
                stringBuilder.append(h.getValue()).append(" ");
                h = h.next;
            }
        }
        stringBuilder.append(" ]");
        return "JDKHashTable{" +
                "size=" + size +
                ", tables=" + stringBuilder.toString() +
                ", capacity=" + capacity +
                '}';
    }

    protected class Node {
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
