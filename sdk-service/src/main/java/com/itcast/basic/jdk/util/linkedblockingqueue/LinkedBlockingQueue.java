package com.itcast.basic.jdk.util.linkedblockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by treey.qian on 2018/3/31.
 */
public class LinkedBlockingQueue {
    private Node head;
    private Node tail;
    private ReentrantLock putLock = new ReentrantLock();
    private Condition putCondition = putLock.newCondition();
    private ReentrantLock takeLock = new ReentrantLock();
    private Condition takeCondition = takeLock.newCondition();
    private int size;
    private int capacity;

    public LinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingQueue(int capacity) {
        this.capacity = capacity;
        head = tail = new Node(null);
    }

    public void put(Object o) throws InterruptedException {
        try {
            putLock.lock();
            while (size == capacity) {
                putCondition.await();
            }
            size++;
            tail = tail.next = new Node(o);
            if (size < capacity) {
                putCondition.signal();
            }
        } finally {
            putLock.unlock();
        }
        if (size == 1) {
            takeLock.lock();
            takeCondition.signal();
            takeLock.unlock();
        }
    }

    public boolean remove(Object o) {
        try {
            takeLock.lock();
            putLock.lock();
            Node h = head.getNext();
            Node prev = null;
            while (h != null) {
                if (h.data == o || (h != null && h.data.equals(o))) {
                    if (prev == null) {
                        head.setNext(h.getNext());
                    } else {
                        prev.setNext(h.getNext());
                    }
                    h.setData(null);
                    h.setNext(null);
                    return true;
                }
                prev = h;
                h = h.getNext();
            }
        } finally {
            takeLock.unlock();
            putLock.unlock();
        }
        return false;
    }

    public boolean contains(Object o) {
        try {
            takeLock.lock();
            putLock.lock();
            Node h = head.getNext();
            while (h != null) {
                if (h.data == o || (h != null && h.data.equals(o))) {
                    return true;
                }
                h = h.getNext();
            }
        } finally {
            takeLock.unlock();
            putLock.unlock();
        }
        return false;
    }


    public Object take() throws InterruptedException {
        Object x;
        try {
            takeLock.lock();
            while (size == 0) {
                takeCondition.await();
            }
            Node h = head;
            Node first = head.getNext();
            head = first;
            h.setData(null);
            h.setNext(null);
            size--;
            if (size > 1) {
                takeCondition.signal();
            }
            x = first.data;
        } finally {
            takeLock.unlock();
        }
        if (size == capacity - 1) {
            putLock.lock();
            putCondition.signal();
            putLock.unlock();
        }
        return x;
    }

    public Object poll() {
        Object x;
        try {
            takeLock.lock();
            if (size == 0) {
                return null;
            }
            Node h = head;
            Node first = head.getNext();
            head = first;
            h.setData(null);
            h.setNext(null);
            size--;
            x = first.data;
            if (size > 1) {
                takeCondition.signal();
            }
        } finally {
            takeLock.unlock();
        }
        if (size < capacity) {
            putLock.lock();
            putCondition.signal();
            putLock.unlock();
        }
        return x;
    }

    public boolean offer(Object o) {
        try {
            putLock.lock();
            if (size < capacity) {
                size++;
                tail = tail.next = new Node(o);
                if (size < capacity) {
                    putCondition.signal();
                }
            }

            if (size == 1) {
                takeLock.lock();
                takeCondition.signal();
                takeLock.unlock();
            }
        } finally {
            putLock.unlock();
        }
        return true;
    }

    public Object peek() {
        try {
            takeLock.lock();
            Node first = head.getNext();
            return first == null ? null : first.data;
        } finally {
            takeLock.unlock();
        }
    }

    public int size() {
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
