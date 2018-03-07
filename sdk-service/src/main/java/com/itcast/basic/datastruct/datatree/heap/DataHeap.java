package com.itcast.basic.datastruct.datatree.heap;

import java.util.LinkedList;

/**
 * Created by treey.qian on 2018/3/7.
 */
public class DataHeap<T extends Comparable> {
    private Node root;
    private LinkedList<Node> linkedList;

    public Node addMaxHeapNode(T data) {
        if (root == null) {
            root = new Node(data, null);
        } else {
            addMaxHeapNode0(data);
        }
        return root;
    }

    private void addMaxHeapNode0(T data) {
        linkedList = new LinkedList();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            Node parent = linkedList.removeFirst();

            if (parent.data.compareTo(data) < 0) {
                T temp = data;
                data = parent.getData();
                parent.data = temp;
            }

            if (parent.left == null) {
                parent.left = new Node(data, parent);
                return;
            } else if (parent.right == null) {
                parent.right = new Node(data, parent);
                return;
            } else {
                linkedList.add(parent.left);
                linkedList.add(parent.right);
            }
        }
    }

    public Node addMinHeapNode(T data) {
        if (root == null) {
            root = new Node(data, null);
        } else {
            addMinHeapNode0(data);
        }
        return root;
    }

    private void addMinHeapNode0(T data) {
        linkedList = new LinkedList();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            Node parent = linkedList.removeFirst();

            if (parent.data.compareTo(data) > 0) {
                T temp = data;
                data = parent.getData();
                parent.data = temp;
            }

            if (parent.left == null) {
                parent.left = new Node(data, parent);
                return;
            } else if (parent.right == null) {
                parent.right = new Node(data, parent);
                return;
            } else {
                linkedList.add(parent.left);
                linkedList.add(parent.right);
            }
        }
    }

    //前序遍历
    public synchronized void preOrderDispaly() {
        //根左右
        StringBuilder stringBuilder = new StringBuilder();
        preOrderDispaly(stringBuilder, root);
        System.out.println("preOrderDispaly tree is " + stringBuilder.toString());
    }

    private void preOrderDispaly(StringBuilder stringBuilder, Node parent) {
        if (parent != null) {

            stringBuilder.append(parent.getData());
            //遍历左子树
            if (parent.left != null) {
                stringBuilder.append(" --> ");
                preOrderDispaly(stringBuilder, parent.left);
            }

            //遍历右子树
            if (parent.right != null) {
                stringBuilder.append(" --> ");
                preOrderDispaly(stringBuilder, parent.right);
            }
        }
    }

    //中序遍历
    public synchronized void midOrderDispaly() {
        //左根右
        StringBuilder stringBuilder = new StringBuilder();
        midOrderDispaly(stringBuilder, root);
        System.out.println("midOrderDispaly tree is " + stringBuilder.substring(0, stringBuilder.lastIndexOf("-->")).toString());
    }

    private void midOrderDispaly(StringBuilder stringBuilder, Node parent) {
        if (parent != null) {
            //遍历左子树
            if (parent.left != null) {
                midOrderDispaly(stringBuilder, parent.left);
            }

            stringBuilder.append(parent.getData());
            stringBuilder.append(" --> ");
            //遍历右子树
            if (parent.right != null) {
                midOrderDispaly(stringBuilder, parent.right);
            }
        }
    }

    //后序遍历
    public synchronized void postOrderDispaly() {
        //左右根
        StringBuilder stringBuilder = new StringBuilder();
        postOrderDispaly(stringBuilder, root);
        System.out.println("postOrderDispaly tree is " + stringBuilder.substring(0, stringBuilder.lastIndexOf("-->")).toString());
    }

    private void postOrderDispaly(StringBuilder stringBuilder, Node parent) {
        if (parent != null) {

            //遍历左子树
            if (parent.left != null) {
                postOrderDispaly(stringBuilder, parent.left);
            }

            //遍历右子树
            if (parent.right != null) {
                postOrderDispaly(stringBuilder, parent.right);
            }

            stringBuilder.append(parent.getData()).append(" --> ");

        }
    }

    private class Node {
        private T data;
        private Node parent;
        private Node left;
        private Node right;

        public Node(T data, Node parent) {
            this.data = data;
            this.parent = parent;
        }

        public T getData() {
            return data;
        }
    }
}
