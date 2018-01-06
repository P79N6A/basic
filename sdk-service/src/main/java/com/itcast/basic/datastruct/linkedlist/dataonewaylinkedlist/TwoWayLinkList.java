package com.itcast.basic.datastruct.linkedlist.dataonewaylinkedlist;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/12/7.
 */
public class TwoWayLinkList<T> implements Serializable {
    private transient int size;
    private Node head;
    private Node tail;


    public synchronized boolean addNode(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is not valid");
        }
        boolean isSuccess = true;
        if (head == null) {
            head = tail = new Node(data);
        } else {
            Node temp = tail;
            tail = tail.next = new Node(data);
            tail.pre = temp;
        }
        size++;
        return isSuccess;
    }

    public synchronized boolean removeNode(T data) {
        boolean isSuccess = true;
        Node temp = head;
        while (temp != null) {
            if (data.equals(head.getData())) {
                temp = temp.next;
                head.next = temp.pre = null;
                head = temp;
                size--;
            } else if (data.equals(temp.getData())) {
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
                temp.next = temp.pre = null;
                size--;
            } else {
                temp = temp.next;
            }
        }
        return isSuccess;
    }

    public synchronized String revert() {
        StringBuilder stringBuilder = new StringBuilder("linkList nodes is { ");
        Node temp = tail;
        while (temp != null) {
            if (temp == head) {
                stringBuilder.append(temp.getData()).append(" ");
            } else {
                stringBuilder.append(temp.getData()).append(" ===> ");
            }
            temp = temp.pre;
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public synchronized String toString() {
        StringBuilder stringBuilder = new StringBuilder("linkList nodes is { ");
        Node temp = head;
        while (temp != null) {
            if (temp == tail) {
                stringBuilder.append(temp.getData()).append(" ");
            } else {
                stringBuilder.append(temp.getData()).append(" ===> ");
            }
            temp = temp.next;
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public synchronized void display() {
        StringBuilder stringBuilder = new StringBuilder("linkList nodes is { ");
        Node temp = head;
        while (temp != null) {
            if (temp == tail) {
                stringBuilder.append(temp.getData()).append(" ");
            } else {
                stringBuilder.append(temp.getData()).append(" ===> ");
            }
            temp = temp.next;
        }
        stringBuilder.append(" }");
        System.out.println(stringBuilder.toString());
    }


    public synchronized int size() {
        return size;
    }

    private class Node {
        private T data;
        private Node next;
        private Node pre;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}
