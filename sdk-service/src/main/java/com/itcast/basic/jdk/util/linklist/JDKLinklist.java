package com.itcast.basic.jdk.util.linklist;

/**
 * Created by treey.qian on 2018/3/20.
 */
public class JDKLinklist {

    private Node head;
    private Node tail;
    private int size;

    public boolean push(Object o) {
        Node h = head;
        Node node = new Node(null, o, h);
        head = node;
        if (h == null) {
            tail = node;
        } else {
            h.prev = node;
        }
        size++;
        return true;
    }

    public Object pop() {
        Node h = head;
        if (h == null) {
            throw new NullPointerException("head is null");
        }
        Node next = h.next;
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.prev = null;
        }
        h.next = null;
        return h.data;
    }


    public int indexOf(Object o) {
        int index = -1;
        Node h = head;
        while (h != null) {
            index++;
            if (h.data.equals(o)) {
                return index;
            }
            h = h.next;
        }
        return index;
    }

    public int lastIndexOf(Object o) {
        int index = -1;
        Node t = tail;
        while (t != null) {
            index++;
            if (t.data.equals(o)) {
                return size - index;
            }
            t = t.prev;
        }
        return index;
    }

    public boolean contains(Object o) {
        Node h = head;
        while (h != null) {
            if (h.data.equals(o)) {
                return true;
            }
            h = h.getNext();
        }
        return false;
    }

    public boolean add(Object o) {
        Node l = tail;
        Node node = new Node(l, o, null);
        tail = node;
        if (l == null) {
            head = node;
        } else {
            l.next = node;
        }
        size++;
        return true;
    }

    public boolean set(int index, Object o) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("index is not valid");
        }
        Node h = head;
        int i = 0;
        while (i < index) {
            h = h.next;
            i++;
        }
        h.data = o;
        return true;
    }

    public boolean add(int index, Object o) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("index is not valid");
        }
        Node h = head;
        int i = 0;
        while (i < index) {
            h = h.next;
            i++;
        }
        Node prev = h.prev;
        Node node = new Node(prev, o, h);
        if (prev == null) {
            head = node;
        } else {
            prev.next = node;
        }
        h.prev = node;
        node.prev = prev;
        size++;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("index is not valid");
        }
        Node h = head;
        for (int i = 0; i < index; i++) {
            h = h.next;
        }
        Node prev = h.prev;
        h.next.prev = prev;
        if (prev == null) {
            head = h.next;
        } else {
            prev.next = h.next;
            h.prev = null;
        }
        h.next = null;
        size--;
        return true;
    }


    public Object get(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("index is not valid");
        }
        Node h = head;
        int i = 0;
        while (i < index) {
            h = h.next;
            i++;
        }
        return h.data;
    }

    public boolean remove(Object o) {
        Node h = head;
        while (h != null) {
            if (h.data.equals(o)) {
                Node prev = h.prev;
                h.next.prev = prev;
                if (prev == null) {
                    head = h.next;
                } else {
                    prev.next = h.next;
                    h.prev = null;
                }
                h.next = null;
                size--;
                return true;
            }
            h = h.getNext();
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node h = head;
        StringBuilder stringBuilder = new StringBuilder("elements[ ");
        while (h != null) {
            stringBuilder.append(h.getData()).append(" ==> ");
            h = h.getNext();
        }

        stringBuilder.append("NULL ]");
        return "JDKLinklist {" +
                stringBuilder.toString() +
                "size=" + size +
                '}';
    }

    private class Node {
        private Object data;
        private Node prev;
        private Node next;

        public Node(Node prev, Object data, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
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
                    "data=" + data +
                    '}';
        }
    }
}
