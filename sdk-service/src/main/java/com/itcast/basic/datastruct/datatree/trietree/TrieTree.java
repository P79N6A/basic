package com.itcast.basic.datastruct.datatree.trietree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qfl on 2018/3/10.
 */
public class TrieTree {
    private Node root;
    private List<Node> leaves = new ArrayList<>();

    public synchronized void addNode(String data) {
        if (data != null && !data.trim().equals("")) {
            char[] chars = data.toCharArray();
            int len = chars.length, index = 0;
            //首次初始化字典树
            if (root == null) {
                root = new Node();
                Node insNode = root;
                while (index < len) {
                    List<Node> list = new ArrayList<>();
                    Node tem = new Node(chars[index++], insNode);
                    System.out.println("插入信息:" + tem.data);
                    list.add(tem);
                    insNode.setChildren(list);
                    if (index == len) {
                        tem.setEnd(true);
                    }
                    insNode = tem;
                }
                System.out.println("**************************************");
            } else {
                //字典树不为null
                int deep = 0;
                Node insNode = root;
                List<Node> tNodes = root.getChildren();
                while (tNodes != null && deep < len) {
                    int j = 0, s = tNodes.size();
                    for (; j < s; j++) {
                        Node node = tNodes.get(j);
                        if (chars[deep] == node.data) {
                            insNode = node;
                            tNodes = insNode.getChildren();
                            deep++;
                            break;
                        } else if (j == s - 1) {
                            //防止死循环
                            tNodes = null;
                        }
                    }
                }

                List<Node> list = insNode.getChildren();
                if (list != null) {
                    Node tem = new Node(chars[deep++], insNode);
                    System.out.println("衔接插入信息:" + tem.data);
                    list.add(tem);
                    insNode.setChildren(list);
                    if (deep == len) {
                        tem.setEnd(true);
                    }
                    insNode = tem;
                }

                while (deep < len) {
                    list = new ArrayList<>();
                    Node tem = new Node(chars[deep++], insNode);
//                    System.out.println("补充插入信息" + tem.data);
                    list.add(tem);
                    insNode.setChildren(list);
                    if (deep == len) {
                        tem.setEnd(true);
                    }
                    insNode = tem;
                }
            }
        }
    }


    public synchronized List<String> printElements() {
        List<String> elements = new ArrayList<>();
        for (Node node : leaves) {
            StringBuilder stringBuilder = new StringBuilder();
            while (node != root) {
                stringBuilder.append(node.data);
                node = node.parent;
            }
            elements.add(stringBuilder.reverse().toString());
        }
        return elements;
    }


    public synchronized void display() {
        display0(root);
//        if (root != null) {
//            System.out.println("root leaf node is " + root.getChildren().size());
//        }
//        for (Node node : leaves) {
//            System.out.println("node is " + node);
//        }
    }

    private void display0(Node parent) {
        if (parent != null) {
            List<Node> nodes = parent.getChildren();
            if (nodes == null || nodes.isEmpty()) {
                leaves.add(parent);
            } else {
                for (Node node : nodes) {
                    if (node.getChildren() != null && node.isEnd) {
                        leaves.add(node);
                    }
                    display0(node);
                }
            }
        }
    }

    private class Node {
        private char data;
        private Node parent;
        private List<Node> children;
        private boolean isEnd = false;

        public Node() {
        }

        public Node(char data, Node parent) {
            this.data = data;
            this.parent = parent;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public Node getParent() {
            return parent;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
