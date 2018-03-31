package com.itcast.basic.jdk.util.linkedblockingdeque;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by treey.qian on 2018/3/31.
 */
public class JDKLinkedBlockingDeque {
    private int capacity;
    private int size;
    private ReentrantLock lock = new ReentrantLock();
    private Condition putCondition = lock.newCondition();
    private Condition takeCondition = lock.newCondition();
    private Node head, tail;

    public JDKLinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public JDKLinkedBlockingDeque(int capacity) {
        this.capacity = capacity;
    }

    public Object pop() {
        try {
            lock.lock();
            Node h = head;
            Object o = h.data;
            h.setData(null);
            h.setNext(null);
            head = h.getNext();
            head.setPrev(null);
            size--;
            if (size == 0) {
                putCondition.signal();
            }
            return o;
        } finally {
            lock.unlock();
        }
    }

    public boolean push(Object o) {
        try {
            lock.lock();
            if (size < capacity) {
                Node node = new Node(o);
                Node h = head;
                if (h == null) {
                    head = tail = node;
                } else {
                    h.setPrev(node);
                    node.setNext(h);
                    head = node;
                }
                size++;
                takeCondition.signal();
                return true;
            }
        } finally {
            lock.unlock();
        }
        return false;
    }

    public Object take() throws InterruptedException {
        try {
            lock.lock();
            while (size == 0) {
                takeCondition.await();
            }
            size--;
            Node h = head;
            Object o = h.data;
            h.setData(null);
            h.setNext(null);
            head = h.getNext();
            head.setPrev(null);
            if (size == 0) {
                putCondition.signal();
            }
            return o;
        } finally {
            lock.unlock();
        }

    }

    public Object poll() {
        try {
            lock.lock();
            Node h = head;
            Object o = h.data;
            h.setData(null);
            h.setNext(null);
            head = h.getNext();
            head.setPrev(null);
            size--;
            if (size == 0) {
                putCondition.signal();
            }
            return o;
        } finally {
            lock.unlock();
        }
    }

    public boolean offer(Object o) {
        try {
            lock.lock();
            if (size < capacity) {
                Node node = new Node(o);
                Node l = tail;
                if (l == null) {
                    head = tail = node;
                } else {
                    node.setPrev(l);
                    tail = l.next = node;
                }
                size++;
                takeCondition.signal();
                return true;
            }
        } finally {
            lock.unlock();
        }
        return false;
    }

    public boolean put(Object o) throws InterruptedException {
        try {
            lock.lock();
            while (size == capacity) {
                putCondition.await();
            }
            Node node = new Node(o);
            Node l = tail;
            if (l == null) {
                head = tail = node;
            } else {
                node.setPrev(l);
                tail = l.next = node;
            }
            size++;
            takeCondition.signal();
        } finally {
            lock.unlock();
        }
        return true;
    }

    public Object peek() {
        try {
            lock.lock();
            return size == 0 ? null : head.data;
        } finally {
            lock.unlock();
        }
    }

    public boolean contains(Object o) {
        Node h = head;
        while (h != null) {
            if (h.data == o || (o != null && o.equals(h.data))) {
                return true;
            }
            h = h.next;
        }
        return false;
    }


    private class Node {
        private Object data;
        private Node prev;
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
    }

}
