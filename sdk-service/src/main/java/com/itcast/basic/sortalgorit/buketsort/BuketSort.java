package com.itcast.basic.sortalgorit.buketsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qfl on 2018/3/10.
 */
public class BuketSort<T extends Comparable> {

    private List<T> elements;
    private List<Node> nodes;
    private String sort = "asc";
    private int bukets;

    public BuketSort(List<T> elements, int bukets) throws Exception {
        if (bukets <= 0) {
            throw new IllegalArgumentException("bukets is not valid");
        }
        this.elements = elements;
        this.bukets = bukets;
        nodes = new ArrayList<>(bukets);
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setBukets(int bukets) {
        this.bukets = bukets;
        nodes = new ArrayList<>(bukets);
    }

    public void sortElements() {
        switch (sort) {
            case "asc":
                ascSort();
                break;
            case "desc":
                descSort();
                break;
        }
    }

    private void descSort() {
        List<T> tem = new ArrayList<T>();
        for (int i = 0, s = elements.size(); i < s; i++) {
            tem.add(elements.get(i));
        }
        //初始化桶
        for (int i = 0; i < bukets; i++) {
            nodes.add(new Node(null));
        }
        //逐个排序
        for (int i = 0, s = elements.size(); i < s; i++) {
            T element = elements.get(i);
            if (element instanceof Integer) {
                int index = hash((Integer) element);
                if (index < bukets) {
                    Node node = new Node(element);
                    Node head = nodes.get(index);
                    if (head.next != null) {
                        while (head.next != null && ((Integer) node.data).compareTo((Integer) head.next.data) < 0) {
                            head = head.next;
                        }
                        node.next = head.next;
                        head.next = node;
                    } else {
                        head.next = node;
                    }
                } else {
                    elements = tem;
                    System.out.println("排序失败,请设置正确数量的桶数");
                    return;
                }
            }
            int index = 0;
            for (int j = nodes.size() - 1; j >= 0; j--) {
                Node node = nodes.get(j);
                while (node.next != null) {
                    elements.set(index++, node.next.data);
                    node = node.next;
                }
            }
        }
    }

    private void ascSort() {
        //初始化桶
        for (int i = 0; i < bukets; i++) {
            nodes.add(new Node(null));
        }
        //逐个排序
        for (int i = 0, s = elements.size(); i < s; i++) {
            T element = elements.get(i);
            if (element instanceof Integer) {
                int index = hash((Integer) element);
                if (index < s) {
                    Node node = new Node(element);
                    Node head = nodes.get(index);
                    if (head.next != null) {
                        while (head.next != null && ((Integer) node.data).compareTo((Integer) head.next.data) > 0) {
                            head = head.next;
                        }
                        node.next = head.next;
                        head.next = node;
                    } else {
                        head.next = node;
                    }
                }
            }
            int index = 0;
            for (Node node : nodes) {
                while (node.next != null) {
                    elements.set(index++, node.next.data);
                    node = node.next;
                }
            }
        }
    }

    public void displayElements() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T element : elements) {
            stringBuilder.append(element).append(" ===> ");
        }
        System.out.println("elements is " + stringBuilder.substring(0, stringBuilder.lastIndexOf("===>")));
    }

    private int hash(int index) {
        return index / bukets;
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
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
