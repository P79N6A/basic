package com.itcast.basic.datastruct.linkedlist.dataonewaylinkedlist;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/12/7.
 */
public class TwoWayLoopLinkList<T> implements Serializable {

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
            Node temp = tail;
            tail = tail.next = new Node(data);
            tail.per = temp;
            tail.next = head;
            head.per = tail;
        }
        return isSuccess;
    }

    public synchronized boolean removeNode(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is not valid");
        }
        boolean isSuccess = true;
        Node temp = head;
        do {
            if (data.equals(head.getData())) {
                temp = temp.next;
                head.per = head.next = null;
                tail.next = head = temp;
            } else if (data.equals(temp.getData())) {
                temp.per.next = temp.next;
                temp.next.per = temp.per;
                temp.next = temp.per = null;
            } else {
                temp = temp.next;
            }
        } while (temp != head);
        return isSuccess;
    }

    public synchronized String revert() {
        StringBuilder stringBuilder = new StringBuilder(" linkList nodes is { ");
        Node temp = tail;
        do {
            if (temp != head) {
                stringBuilder.append(temp.getData()).append(" ===> ");
            } else {
                stringBuilder.append(temp.getData());
            }
            temp = temp.per;
        } while (temp != tail);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public synchronized String toString() {
        StringBuilder stringBuilder = new StringBuilder(" linkList nodes is { ");
        Node temp = head;
        do {
            if (temp != tail) {
                stringBuilder.append(temp.getData()).append(" ===> ");
            } else {
                stringBuilder.append(temp.getData());
            }
            temp = temp.next;
        } while (temp != head);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public synchronized void display() {
        StringBuilder stringBuilder = new StringBuilder(" linkList nodes is { ");
        Node temp = head;
        do {
            if (temp != tail) {
                stringBuilder.append(temp.getData()).append(" ===> ");
            } else {
                stringBuilder.append(temp.getData());
            }
            temp = temp.next;
        } while (temp != head);
        stringBuilder.append(" }");
        System.out.println(stringBuilder.toString());
    }

    public synchronized int size() {
        return size;
    }

    private class Node {
        private T data;
        private Node per;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}
