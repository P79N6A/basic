package com.itcast.basic.jdk.util.concurrent.concurrenthashmap;

/**
 * Created by treey.qian on 2018/3/29.
 */
public class JDKConcurrentHashMap {
    private int size;
    private int capacity;
    private Node[] tables;

    public JDKConcurrentHashMap() {
        capacity = 16;
        tables = new Node[capacity];
    }

    public Object put(Object key, Object value) {
        if (key == null || value == null) {
            throw new NullPointerException("key and value is not null");
        }
        int index = index(key);
        Node h = tables[index];
        Node node = new Node(key, value, null);
        if (h == null) {
            //原子添加
            while (tables[index] == null) {
                tables[index] = node;
            }
            size++;
            return null;
        } else {
            synchronized (h) {
                do {
                    if (h.getKey().equals(key)) {
                        Object oldV = h.getValue();
                        h.setValue(value);
                        return oldV;
                    }
                } while ((h != null) && (h = h.getNext()) != null);
                size++;
                h.setNext(node);
                return null;
            }
        }
    }

    public Object remove(Object key) {
        if (key == null) {
            throw new NullPointerException("key is not null");
        }
        int index = index(key);
        Node h = tables[index];
        Node prev = null;
        while (h != null) {
            synchronized (h) {
                if (h.getKey().equals(key)) {
                    Object oldV = h.getValue();
                    if (prev == null) {
                        tables[index] = h.getNext();
                    } else {
                        prev.setNext(h.getNext());
                    }
                    h.setNext(null);
                    size--;
                    return oldV;
                }
                prev = h;
                h = h.getNext();
            }
        }
        return false;
    }

    public Object get(Object key) {
        if (key == null) {
            throw new NullPointerException("key is not null");
        }
        int index = index(key);
        Node h = tables[index];
        while (h != null) {
            if (h.getKey().equals(key)) {
                return h.getValue();
            }
            h = h.getNext();
        }
        return null;
    }

    public boolean containKey(Object key) {
        if (key == null) {
            throw new NullPointerException("key is not null");
        }
        int index = index(key);
        Node h = tables[index];
        while (h != null) {
            if (h.getKey().equals(key)) {
                return true;
            }
            h = h.getNext();
        }
        return false;
    }

    public boolean containValue(Object value) {
        if (value == null) {
            throw new NullPointerException("value is not null");
        }
        for (int i = 0, len = tables.length; i < len; i++) {
            Node h = tables[i];
            while (h != null) {
                if (h.getValue().equals(value)) {
                    return true;
                }
                h = h.getNext();
            }
        }
        return false;
    }

    private int index(Object key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % capacity;
    }

    public synchronized int capacity() {
        return capacity;
    }

    public synchronized int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[ ");
        for (Node node : tables) {
            while (node != null) {
                stringBuilder.append(node.getValue()).append(" ");
                node = node.getNext();
            }
        }
        stringBuilder.append(" ]");
        return "JDKConcurrentHashMap{" +
                "size=" + size +
                ", capacity=" + capacity +
                ", tables=" + stringBuilder.toString() +
                '}';
    }

    private class Node {
        private Object value;
        private Object key;
        private Node next;

        public Node(Object key, Object value, Node next) {
            this.value = value;
            this.key = key;
            this.next = next;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
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
                    ", key=" + key +
                    '}';
        }
    }
}
