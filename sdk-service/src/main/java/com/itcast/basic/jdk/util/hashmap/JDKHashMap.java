package com.itcast.basic.jdk.util.hashmap;

/**
 * Created by treey.qian on 2018/3/21.
 */
public class JDKHashMap {
    private int capacity;
    private int size;
    private Node[] tables = {};


    public JDKHashMap() {
        capacity = 16;
        tables = new Node[capacity];
    }

    public Object put(Object key, Object value) {
        if (key == null) {
            return putNullKey(value);
        }
        return putValue(key, value);
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
                Object old = h.getValue();
                h.setValue(value);
                return old;
            }
        } while (h.next != null && (h = h.next) != null);
        h.next = new Node(null, value, null);
        size++;
        return null;
    }

    private Object putValue(Object key, Object value) {
        int index = index(key);
        Node h = tables[index];
        if (h == null) {
            tables[index] = new Node(key, value, null);
            size++;
            return null;
        }
        do {
            if (key.equals(h.getKey())) {
                Object old = h.getValue();
                h.setValue(value);
                return old;
            }
        } while (h.next != null && (h = h.next) != null);
        h.next = new Node(key, value, null);
        size++;
        return null;
    }

    public Object get(Object key) {
        if (key == null) {
            return getNullValue();
        }
        return getValue(key);
    }

    private Object getNullValue() {
        Node h = tables[0];
        while (h != null) {
            if (h.getKey() == null) {
                return h.value;
            }
            h = h.getNext();
        }
        return null;
    }

    private Object getValue(Object key) {
        int index = index(key);
        Node h = tables[index];
        while (h != null) {
            if (h.getKey().equals(key)) {
                return h.value;
            }
            h = h.getNext();
        }
        return null;
    }

    public boolean containsValue(Object value) {
        for (int i = 0; i < capacity; i++) {
            Node h = tables[i];
            while (h != null) {
                if (value == null) {
                    if (h.getValue() == null) {
                        return true;
                    }
                } else {
                    if (h.getValue() != null && h.getValue().equals(value)) {
                        return true;
                    }
                }
                h = h.getNext();
            }
        }
        return false;
    }

    public boolean containsKey(Object key) {
        if (key == null) {
            Node n = tables[0];
            while (n != null) {
                if (n.getKey() == null) {
                    return true;
                }
            }
            return false;
        }

        for (int i = 1; i < capacity; i++) {
            Node h = tables[i];
            while (h != null) {
                if (h.getKey().equals(key)) {
                    return true;
                }
                h = h.getNext();
            }
        }
        return false;
    }

    public Object remove(Object key) {
        if (key == null) {
            return removeNullKey();
        }
        return removeKey(key);
    }


    private Object removeNullKey() {
        Node node = tables[0];
        Node prev = null;
        while (node != null) {
            if (node.getKey() == null) {
                Object oldV = node.value;
                if (prev == null) {
                    tables[0] = node.next;
                } else {
                    prev.next = node.next;
                }
                node.next = null;
                size--;
                return oldV;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    private Object removeKey(Object key) {
        int index = index(key);
        Node node = tables[index];
        Node prev = null;
        while (node != null) {
            if (key.equals(node.getKey())) {
                Object oldV = node.value;
                if (prev == null) {
                    tables[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                node.next = null;
                size--;
                return oldV;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    public Node[] tables() {
        return tables;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    private int index(Object key) {
        return Math.abs(hash(key) % capacity);
    }

    private int hash(Object key) {
        return key == null ? 0 : key.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[ ");
        for (int i = 0; i < capacity; i++) {
            Node h = tables[i];
            while (h != null) {
                stringBuilder.append(h.getValue()).append(" ");
                h = h.getNext();
            }
        }
        stringBuilder.append(" ]");
        return "JDKHashMap{" +
                "capacity=" + capacity +
                ", size=" + size +
                ", tables=" + stringBuilder +
                '}';
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public class Node {
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
