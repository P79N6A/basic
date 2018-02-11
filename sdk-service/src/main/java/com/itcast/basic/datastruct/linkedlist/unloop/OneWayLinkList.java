package com.itcast.basic.datastruct.linkedlist.unloop;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/12/6.
 */
public class OneWayLinkList<T> implements Serializable {

    private Node head;
    private Node tail;

    private transient int size;

    public synchronized int size() {
        return size;
    }

    public synchronized boolean addNode(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is not null");
        }
        boolean isSuccess = true;
        try {
            if (head == null) {
                head = tail = new Node(data);
            } else {
                tail = tail.next = new Node(data);
            }
            size++;
        } catch (Exception e) {
            isSuccess = false;
            System.out.println("");
        }
        return isSuccess;
    }

    public synchronized boolean removeNode(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is not valid");
        }
        boolean isSuccess = true;
        Node temp = head;
        Node pre = null;
        while (temp != null) {
            if (data.equals(head.getData())) {
                temp = head.next;
                head.next = null;
                head = temp;
                size--;
            } else if (data.equals(temp.getData())) {
                pre.next = temp.next;
                temp.next = null;
                temp = pre.next;
                size--;
            } else {
                pre = temp;
                temp = temp.next;
            }
        }
        return isSuccess;
    }

    public synchronized void display() {
        StringBuilder stringBuilder = new StringBuilder("linkList nodes is { ");
        Node temp = head;
        while (temp != null) {
            stringBuilder.append(" ").append(temp.getData());
            temp = temp.next;
        }
        stringBuilder.append(" }");
        System.out.println(stringBuilder.toString());
    }

    public synchronized String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            stringBuilder.append(" ").append(temp.getData());
            temp = temp.next;
        }
        return stringBuilder.toString();
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

}
