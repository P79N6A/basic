package com.itcast.basic.datastruct.datatree.twotree;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/12/11.
 */
public class DataTwoTree<T extends Comparable> implements Serializable {
    private Node root;
    private transient int size;

    public synchronized boolean addNode(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is not valid");
        }
        boolean isSuccess = true;
        if (root == null) {
            root = new Node(null, data);
            size++;
            System.out.println("插入节点root, data=" + data);
        } else {
            createNode(root, data);
        }
        return isSuccess;
    }

    private void createNode(Node parent, T data) {
        //遍历搜索树
        if (data.compareTo(parent.getData()) < 0) {
            //data<node data ==> function compareTo return -1 搜索左子树
            if (parent.left == null) {
                parent.left = new Node(parent, data);
                size++;
                System.out.println("插入left节点data=" + data + " 父节点data=" + parent.getData());
            } else {
                //开始递归
                createNode(parent.left, data);
            }
        } else {
            //data>=node data ==> function compareTo return  搜索右子树
            if (parent.right == null) {
                parent.right = new Node(parent, data);
                size++;
                System.out.println("插入right节点data=" + data + " 父节点data=" + parent.getData());
            } else {
                //开始递归
                createNode(parent.right, data);
            }
        }
    }

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

    public synchronized void midOrderDispaly() {
        //左根右

    }

    public synchronized void postOrderDispaly() {
        //左右根

    }

    public synchronized int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size() > 0) {
            return "tree has " + size() + " nodes please use function display them";
        } else {
            return "tree has no nodes";
        }
    }

    public synchronized boolean removeNode(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is not valid");
        }
        boolean isSuccess = true;

        return isSuccess;
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

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{"
                    + "data=" + data +
                    '}';
        }
    }
}
