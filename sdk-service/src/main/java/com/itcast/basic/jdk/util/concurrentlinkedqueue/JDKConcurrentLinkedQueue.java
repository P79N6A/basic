package com.itcast.basic.jdk.util.concurrentlinkedqueue;

/**
 * Created by qfl on 2018/3/31.
 */
public class JDKConcurrentLinkedQueue {

    private Node head;
    private Node tail;

    public JDKConcurrentLinkedQueue() {
        head = tail = new Node(null);
    }


    public boolean offer(Object o) {
        Node t = tail;
        while (true) {
            if (t == null) {
                tail = compareAndSwap(null, t, o);
            } else {
                t = t.getNext();
            }
        }
    }


    private Node compareAndSwap(Node except, Node cur, Object newV) {
        return null;
    }

    public boolean contains(Object o) {
        Node h = head;
        while (h != null) {
            if (o == h.data || (o != null && o.equals(h.data))) {
                return true;
            }
            h = h.getNext();
        }
        return false;
    }

    public int size() {
        Node h = head;
        int size = 0;
        while (h != null) {
            size++;
            h = h.getNext();
        }
        return size;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
