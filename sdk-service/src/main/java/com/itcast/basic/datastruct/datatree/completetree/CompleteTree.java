package com.itcast.basic.datastruct.datatree.completetree;

import java.util.LinkedList;

/**
 * Created by treey.qian on 2018/3/7.
 */
public class CompleteTree<T extends Comparable> {

    private LinkedList<Node> nodeLinkedList;
    private Node root;

    public void addNode(T data) {
        if (root == null) {
            root = new Node(null, data);
        } else {
            addNode0(data);
        }
    }

    private void addNode0(T data) {
        nodeLinkedList = new LinkedList<>();
        nodeLinkedList.add(root);
        while (!nodeLinkedList.isEmpty()) {
            Node parent = nodeLinkedList.removeFirst();
            if (parent.left == null) {
                parent.left = new Node(parent, data);
                return;
            } else if (parent.right == null) {
                parent.right = new Node(parent, data);
                return;
            } else {
                nodeLinkedList.add(parent.left);
                nodeLinkedList.add(parent.right);
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
        private Node parent;
        private Node left;
        private Node right;
        private T data;

        public Node(Node parent, T data) {
            this.parent = parent;
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}
