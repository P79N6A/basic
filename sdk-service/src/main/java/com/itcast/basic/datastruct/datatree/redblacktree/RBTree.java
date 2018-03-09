package com.itcast.basic.datastruct.datatree.redblacktree;

import com.itcast.basic.datastruct.datatree.ColorModel;


/**
 * Created by treey.qian on 2018/3/8.
 */
public class RBTree<T extends Comparable> {

    private Node root;
    private int size;
    private Node NIL = new Node(null, ColorModel.BLACK);

    public synchronized void addNode(T data) {
        if (root == null) {
            root = initInsertNode(null, data);
            root.color = ColorModel.BLACK;
        } else {
            addNode0(root, data);
        }
    }

    private boolean addNode0(Node parent, T data) {
        boolean isSwap = false;
        if (parent != null) {
            int result = data.compareTo(parent.data);
            if (result > 0) {
                //insert right
                if (parent.right == NIL) {
                    //父节点为黑色不需要调整
                    Node insNode = initInsertNode(parent, data);
                    parent.right = insNode;
                    System.out.println("父节点" + parent + ",插入右节点" + insNode);
                    if (parent.color == ColorModel.RED) {
                        //祖父节点（颜色一定为黑色）
                        Node gNode = parent.parent;
                        if (gNode.right == parent) {
                            //不平衡树在祖父节点右子树
                            if (gNode.left != NIL) {
                                //叔父节点
                                Node uNode = gNode.left;
                                if (uNode.color == ColorModel.BLACK) {
                                    //左旋祖父节点
                                    leftBlance(gNode);
                                } else {
                                    gNode.color = ColorModel.RED;
                                    parent.color = ColorModel.BLACK;
                                    uNode.color = ColorModel.BLACK;
                                    //需要递归调整节点颜色
                                    isSwap = true;
                                }
                            } else {
                                //左旋祖父节点
                                leftBlance(gNode);
                            }
                        } else {
                            //不平衡树在祖父节点左子树
                            if (gNode.right != NIL) {
                                //叔父节点
                                Node uNode = gNode.right;
                                if (uNode.color == ColorModel.BLACK) {
                                    //左旋父节点 右旋祖父节点
                                    leftBlance(parent);
                                    rightBlance(gNode);
                                } else {
                                    gNode.color = ColorModel.RED;
                                    parent.color = ColorModel.BLACK;
                                    uNode.color = ColorModel.BLACK;
                                    //需要递归调整节点颜色
                                    isSwap = true;
                                }
                            } else {
                                //左旋父节点 右旋祖父节点
                                leftBlance(parent);
                                rightBlance(gNode);
                            }
                        }
                    }
                } else {
                    boolean isBlance = addNode0(parent.right, data);
                    if (isBlance) {
                        Node rNode = parent.parent;
                        if (rNode == null || rNode == root) {
                            root.color = ColorModel.BLACK;
                            return false;
                        } else {
                            Node pNode = rNode.parent;
                            System.out.println("rNode=" + rNode);
                            if (pNode.color == ColorModel.RED) {
                                Node gNode = pNode.parent;
                                if (gNode.left == pNode) {
                                    gNode.right.color = ColorModel.BLACK;
                                } else {
                                    gNode.left.color = ColorModel.BLACK;
                                }
                                gNode.color = ColorModel.RED;
                                pNode.color = ColorModel.BLACK;
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            } else if (result < 0) {
                //insert left
                if (parent.left == NIL) {
                    //父节点为黑色不需要调整
                    Node insNode = initInsertNode(parent, data);
                    parent.left = insNode;
                    System.out.println("父节点" + parent + ",插入左节点" + insNode);
                    if (parent.color == ColorModel.RED) {
                        //祖父节点一定为黑色
                        Node gNode = parent.parent;
                        if (gNode.left == parent) {
                            //不平衡节点在左子树
                            if (gNode.right != NIL) {
                                Node uNode = gNode.right;
                                if (uNode.color == ColorModel.BLACK) {
                                    //右旋祖父节点
                                    rightBlance(gNode);
                                } else {
                                    gNode.color = ColorModel.RED;
                                    parent.color = ColorModel.BLACK;
                                    uNode.color = ColorModel.BLACK;
                                    //需要递归调整节点颜色
                                    isSwap = true;
                                }
                            } else {
                                //右旋祖父节点
                                rightBlance(gNode);
                            }
                        } else {
                            //不平衡节点在右子树
                            if (gNode.left != NIL) {
                                Node uNode = gNode.left;
                                if (uNode.color == ColorModel.BLACK) {
                                    //右旋父节点 左旋祖父节点
                                    rightBlance(parent);
                                    leftBlance(gNode);
                                } else {
                                    gNode.color = ColorModel.RED;
                                    parent.color = ColorModel.BLACK;
                                    uNode.color = ColorModel.BLACK;
                                    //需要递归调整节点颜色
                                    isSwap = true;
                                }
                            } else {
                                //右旋父节点 左旋祖父节点
                                rightBlance(parent);
                                leftBlance(gNode);
                            }
                        }
                    }
                } else {
                    boolean isBlance = addNode0(parent.left, data);
                    if (isBlance) {
                        Node rNode = parent.parent;
                        if (rNode == null || rNode == root) {
                            root.color = ColorModel.BLACK;
                            return false;
                        } else {
                            Node pNode = rNode.parent;
                            if (pNode.color == ColorModel.RED) {
                                Node gNode = pNode.parent;
                                if (gNode.left == pNode) {
                                    gNode.right.color = ColorModel.BLACK;
                                } else {
                                    gNode.left.color = ColorModel.BLACK;
                                }
                                gNode.color = ColorModel.RED;
                                pNode.color = ColorModel.BLACK;
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return isSwap;
    }


    //前序遍历 根左右
    public synchronized void preDisplay() {
        StringBuilder stringBuilder = new StringBuilder();
        preDisplay0(stringBuilder, root);
        System.out.println("nodes is " + stringBuilder.toString());
    }

    private void preDisplay0(StringBuilder stringBuilder, Node parent) {
        if (parent != null) {
            stringBuilder.append(parent);

            if (parent.left != NIL) {
                stringBuilder.append(" ===> ");
                preDisplay0(stringBuilder, parent.left);
            }

            if (parent.right != NIL) {
                stringBuilder.append(" ===> ");
                preDisplay0(stringBuilder, parent.right);
            }
        }
    }

    //中序遍历 左根右
    public synchronized void midDisplay() {
        StringBuilder stringBuilder = new StringBuilder();
        midDisplay0(stringBuilder, root);
        System.out.println("nodes is " + stringBuilder.substring(0, stringBuilder.lastIndexOf("====>")));
    }

    private void midDisplay0(StringBuilder stringBuilder, Node parent) {
        if (parent != null) {
            if (parent.left != NIL) {
                midDisplay0(stringBuilder, parent.left);
            }
            stringBuilder.append(parent).append("====>");
            if (parent.right != NIL) {
                midDisplay0(stringBuilder, parent.right);
            }
        }
    }

    //后续遍历 左右根
    public synchronized void postDisplay() {
        StringBuilder stringBuilder = new StringBuilder();
        postDisplay0(stringBuilder, root);
        System.out.println("nodes is " + stringBuilder.substring(0, stringBuilder.lastIndexOf("====>")));
    }

    private void postDisplay0(StringBuilder stringBuilder, Node parent) {
        if (parent != null) {
            if (parent.left != NIL) {
                midDisplay0(stringBuilder, parent.left);
            }
            if (parent.right != NIL) {
                midDisplay0(stringBuilder, parent.right);
            }
            stringBuilder.append(parent).append("====>");
        }
    }

    public synchronized int size() {
        return size;
    }

    //右旋转
    private void rightBlance(Node node) {
        //右旋节点左子树一定存在
        Node lNode = node.left;
        if (lNode.right != NIL) {
            lNode.right.parent = node;
        }
        Node pNode = node.parent;
        lNode.parent = pNode;
        if (pNode != null) {
            if (pNode.left == node) {
                pNode.left = lNode;
            } else {
                pNode.right = lNode;
            }
        } else {
            root = lNode;
        }
        node.left = lNode.right;
        lNode.right = node;
        node.parent = lNode;
        node.color = ColorModel.RED;
        lNode.color = ColorModel.BLACK;
    }

    //左旋转
    private void leftBlance(Node node) {
        //左旋节点一定存在右子树
        Node rNode = node.right;

        Node pNode = node.parent;
        if (rNode.left != NIL) {
            rNode.left.parent = node;
        }
        rNode.parent = pNode;
        if (pNode != null) {
            if (pNode.left == node) {
                pNode.left = rNode;
            } else {
                pNode.right = rNode;
            }
        } else {
            root = rNode;
        }
        node.right = rNode.left;
        rNode.left = node;
        node.parent = rNode;
        node.color = ColorModel.RED;
        rNode.color = ColorModel.BLACK;
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

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", color=" + color +
                    '}';
        }
    }

    private Node initInsertNode(Node parent, T data) {
        size++;
        return new Node(parent, NIL, NIL, data, ColorModel.RED);
    }

}
