package com.itcast.basic.jdk.util.linklist;

/**
 * Created by treey.qian on 2018/3/20.
 */
public class JDKLinklist {

    private Node head;
    private Node tail;
    private int size;


    public boolean contains(Object o) {
        Node h = head;
        while (h != null) {
            if (h.equals(o)) {
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

    public boolean add(int index, Object o) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("index is not valid");
        }

        return true;
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
