package com.itcast.basic.datastruct.datatree.redblacktree;

import com.itcast.basic.datastruct.datatree.ColorModel;


/**
 * Created by treey.qian on 2018/3/8.
 */
public class RBTree<T extends Comparable> {

    private Node root;
    private Node NIL = new Node(null, ColorModel.BLACK);

    public void addNode(T data) {
        if (root == null) {

        } else {

        }
    }

    private class Node {
        private Node parent;
        private Node left;
        private Node right;
        private T data;
        private ColorModel color;

        public Node(T data, ColorModel color) {
            this.data = data;
            this.color = color;
        }

        public Node(Node parent, Node left, Node right, T data, ColorModel color) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.data = data;
            this.color = color;
        }
    }

    private Node initInsertNode(Node parent, Node left, Node right, T data) {
        return new Node(parent, NIL, NIL, data, ColorModel.RED);
    }

}
