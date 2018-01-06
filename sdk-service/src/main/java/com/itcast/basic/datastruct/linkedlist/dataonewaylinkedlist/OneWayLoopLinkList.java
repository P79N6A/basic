package com.itcast.basic.datastruct.linkedlist.dataonewaylinkedlist;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/12/6.
 */
public class OneWayLoopLinkList<T> implements Serializable {

    private Node head;
    private Node tail;
    private transient int size;

    public synchronized boolean addNode(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is not valid");
        }
        boolean isSuccess = true;
        if (head == null) {
            head = tail = new Node(data);
        } else {
            tail = tail.next = new Node(data);
            tail.next = head;
        }
        size++;
        return isSuccess;
    }

    public synchronized boolean removeNode(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is not valid");
        }
        boolean isSuccess = true;
        Node temp = head;
        Node per = null;
        do {
            if (data.equals(head.getData())) {
                temp = head.next;
                head.next = null;
                tail.next = head = temp;
                size--;
            } else if (data.equals(temp.getData())) {
                per.next = temp.next;
                temp.next = null;
                temp = per.next;
                size--;
            } else {
                per = temp;
                temp = temp.next;
            }
        } while (temp != head);
        return isSuccess;
    }

    public synchronized int size() {
        return size;
    }

    public synchronized String toString() {
        StringBuilder stringBuilder = new StringBuilder("linkList nodes is { ");
        Node temp = head;
        do {
            stringBuilder.append(temp.getData()).append(" ");
            temp = temp.next;
        } while (temp != head);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public synchronized void display() {
        StringBuilder stringBuilder = new StringBuilder("linkList nodes is { ");
        Node temp = head;
        do {
            stringBuilder.append(temp.getData()).append(" ");
            temp = temp.next;
        } while (temp != head);
        stringBuilder.append(" }");
        System.out.println(stringBuilder.toString());
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }
    }
}
