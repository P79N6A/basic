package com.itcast.basic.datastruct.datatree.redblacktree;

import com.itcast.basic.datastruct.datatree.ColorModel;
import com.itcast.basic.datastruct.datatree.ElectoralModel;


/**
 * Created by treey.qian on 2018/3/8.
 */
public class RBTree<T extends Comparable> {

    private Node root;
    private int size;
    private ElectoralModel defaultMode = ElectoralModel.LEFT;
    private Node NIL = new Node(null, ColorModel.BLACK);

    public void setDefaultMode(ElectoralModel defaultMode) {
        this.defaultMode = defaultMode;
    }

    public synchronized Node findNode(T data) {
        return findNode0(root, data);
    }

    //查找节点
    private Node findNode0(Node parent, T data) {
        if (parent != null) {
            int result = parent.data.compareTo(data);
            if (result > 0) {
                return findNode0(parent.left, data);
            } else if (result < 0) {
                return findNode0(parent.right, data);
            } else {
                return parent;
            }
        }
        return null;
    }

    public synchronized void addNode(T data) {
        if (root == null) {
            root = initInsertNode(null, data);
            root.color = ColorModel.BLACK;
        } else {
            addNode0(root, data);
        }
    }

    //添加节点
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
                                    System.out.println("需要一次旋转" + "左旋转" + gNode);
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
                                System.out.println("需要一次旋转" + "左旋转" + gNode);
                                //左旋祖父节点
                                leftBlance(gNode);
                            }
                        } else {
                            //不平衡树在祖父节点左子树
                            if (gNode.right != NIL) {
                                //叔父节点
                                Node uNode = gNode.right;
                                if (uNode.color == ColorModel.BLACK) {
                                    System.out.println("需要两次旋转" + "左旋转" + parent + " 右旋转" + gNode);
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
                                System.out.println("需要两次旋转" + "左旋转" + parent + " 右旋转" + gNode);
                                //左旋父节点 右旋祖父节点
                                leftBlance(parent);
                                rightBlance(gNode);
                            }
                        }
                    }
                } else {
                    boolean isBlance = addNode0(parent.right, data);
                    if (isBlance) {//isBlance为true ===> parent为红色节点
                        System.out.println("********右子树向上递归调整************");
                        return adjustNode(parent);
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
                                    System.out.println("需要一次旋转" + "右旋转" + gNode);
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
                                System.out.println("需要两次旋转" + "右旋转" + gNode);
                                //右旋祖父节点
                                rightBlance(gNode);
                            }
                        } else {
                            //不平衡节点在右子树
                            if (gNode.left != NIL) {
                                Node uNode = gNode.left;
                                if (uNode.color == ColorModel.BLACK) {
                                    System.out.println("需要两次旋转" + "右旋转" + parent + " 左旋转" + gNode);
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
                                System.out.println("需要两次旋转" + "右旋转" + parent + " 左旋转" + gNode);
                                //右旋父节点 左旋祖父节点
                                rightBlance(parent);
                                leftBlance(gNode);
                            }
                        }
                    }
                } else {
                    boolean isBlance = addNode0(parent.left, data);
                    if (isBlance) {
                        System.out.println("********左子树向上递归调整************");
                        return adjustNode(parent);
                    }
                }
            }
        }
        return isSwap;
    }

    //着色调整
    private boolean adjustNode(Node parent) {
        Node pNode = parent.parent;
        if (pNode == null || pNode == root) {
            root.color = ColorModel.BLACK;
            return false;
        } else {
            if (pNode.color == ColorModel.BLACK) { //父节点pNode为黑色 红黑树调整结束
                System.out.println("********无需调整************");
                return false;
            } else {//父节点pNode为红色 则gNode存在且为黑色节点 红黑树是否调整需依据叔父节点uNode颜色决定
                Node gNode = pNode.parent;
                if (gNode.left == pNode) {//叔父节点在右子树
                    Node uNode = gNode.right;
                    if (uNode.color == ColorModel.RED) {//仅需递归着色调整
                        System.out.println("********仅需递归着色调整************" + parent);
                        uNode.color = ColorModel.BLACK;
                        pNode.color = ColorModel.BLACK;
                        gNode.color = ColorModel.RED;
                        return true;
                    } else {//需旋转调整
                        if (pNode.right == parent) {//节点parent为父节点pNode的左子树 需两次旋转
                            System.out.println("********需要两次调整************" + "左旋pNode=" + pNode + " 右旋gNode=" + gNode);
                            //左旋pNode 右旋gNode
                            leftBlance(pNode);
                            rightBlance(gNode);
                        } else {//节点parent为父节点pNode的左子树 需一次旋转
                            //右旋gNode
                            System.out.println("********需要一次调整************" + " 右旋gNode=" + gNode);
                            rightBlance(gNode);
                        }
                        return false;
                    }
                } else {//叔父节点在左子树
                    Node uNode = gNode.left;
                    if (uNode.color == ColorModel.RED) {//仅需递归着色调整
                        System.out.println("********仅需递归着色调整************" + parent);
                        uNode.color = ColorModel.BLACK;
                        pNode.color = ColorModel.BLACK;
                        gNode.color = ColorModel.RED;
                        return true;
                    } else {//需旋转调整
                        if (pNode.left == parent) {//节点parent为父节点pNode的左子树 需两次旋转
                            System.out.println("********需要两次调整************" + "右旋pNode=" + pNode + " 左旋gNode=" + gNode);
                            //右旋pNode 左旋gNode
                            rightBlance(pNode);
                            leftBlance(gNode);
                        } else {//节点parent为父节点pNode的右子树 需一次旋转
                            //左旋gNode
                            System.out.println("********需要一次调整************" + " 左旋gNode=" + gNode);
                            leftBlance(gNode);
                        }
                        return false;
                    }
                }
            }
        }
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
        //着色调整(交换节点颜色)
        ColorModel temp = node.color;
        node.color = rNode.color;
        rNode.color = temp;
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
        //着色调整(交换节点颜色)
        ColorModel temp = node.color;
        node.color = lNode.color;
        lNode.color = temp;
    }

    public void removeNode(T data) {
        removeNode0(data, root);
    }

    private boolean removeNode0(T data, Node parent) {
        if (parent != null) {
            int result = data.compareTo(parent.data);
            if (result > 0) {
                boolean isSwap = removeNode0(data, parent.right);
            } else if (result < 0) {
                boolean isSwap = removeNode0(data, parent.left);
            } else {
                if (parent.left == NIL && parent.right != NIL) { //被删除节点没有左子树
                    System.out.println("实现中");
                } else if (parent.left != NIL && parent.right == NIL) {//删除节点没有右子树
                    rotateRightNode(parent);
                } else {  //被删除节点度为2 左子树最大节点 右子树最小节点
                    Swap swap;
                    switch (defaultMode.getIndex()) {
                        case 0:
                            swap = swapLeftNode(parent);
                            parent.data = swap.getData();
                            return swap.isSwap();
                        case 1:
                            swap = swapRightNode(parent);
                            parent.data = swap.getData();
                            return swap.isSwap();
                    }
                }
            }
        }
        return false;
    }

    //左子树是否存在最大值
    private Swap swapLeftNode(Node parent) {
        Node lNode = parent.left;
        if (lNode.right == NIL) {
            return rotateRightNode(lNode);
        }
        return swapRightNode0(lNode.right);
    }

    //选取左子树最大值
    private Swap swapRightNode0(Node parent) {
        if (parent.right == NIL) {//删除节点不存在右子树（右孩子）
            return rotateRightNode(parent);
        }
        return swapRightNode0(parent.right);
    }

    private Swap rotateRightNode(Node parent) {
        Node pNode = parent.parent;
        if (parent.color == ColorModel.RED) {//被删除节点为红色 则其左孩子节点必定为NIL
            System.out.println("被删除节点" + parent + "为红色且其左孩子为NIL直接删除无需调整");
            pNode.right = NIL;
        } else {//被删除节点为黑色
            if (pNode.color == ColorModel.RED) {//pNode必定存在黑色左子树
                if (parent.left != NIL) {//parent.left存在则一定为红色
                    System.out.println("被删除节点父节点" + pNode + "为红色 " + "被删除节点" + parent + "为黑色且其必定存在红色左孩子删除后调整" + parent.left + "为黑色即可");
                    parent.left.color = ColorModel.BLACK;
                    parent.left.parent = pNode;
                    pNode.right = parent.left;
                } else {//parent.left为NIL
                    //交换颜色
                    ColorModel temp = pNode.color;
                    pNode.color = pNode.left.color;
                    pNode.left.color = temp;
                    Node lNode = pNode.left;
                    if (lNode.right == NIL && lNode.left != NIL) {
                        System.out.println("被删除节点父节点" + pNode + "为红色 " + "被删除节点" + parent + "为黑色且其左孩子为NIL删除后需一次旋转" + "右旋" + pNode);
                        pNode.right = NIL;
                        //右旋pNode
                        rightBlance(pNode);
                    } else if (lNode.right != NIL) {
                        System.out.println("被删除节点父节点" + pNode + "为红色 " + " 被删除节点" + parent + "为黑色且其左孩子为NIL删除后需两次旋转" + "左旋" + lNode + "右旋" + pNode);
                        pNode.right = NIL;
                        //左旋lNode 右旋pNode
                        leftBlance(lNode);
                        rightBlance(pNode);
                        if (lNode.left != NIL) {
                            //重新着色
                            lNode.color = ColorModel.BLACK;
                            pNode.color = ColorModel.BLACK;
                        }
                    }
                }
            } else {//pNode为黑色
                if (parent.left != NIL) {//parent.left存在则一定为红色
                    System.out.println("被删除节点父节点" + pNode + "为黑色 " + " 且被删除节点" + parent + "为黑色且其必定存在红色左孩子删除后调整" + parent.left + "为黑色即可");
                    parent.left.color = ColorModel.BLACK;
                    parent.left.parent = pNode;
                    pNode.right = parent.left;
                } else {//lNode必定存在
                    pNode.left = NIL;
                    Node lNode = pNode.left;
                    if (lNode.color == ColorModel.BLACK) {//lNode至少存在一个红色孩子
                        if (lNode.left != NIL && lNode.right == NIL) {//lNode.left为红色
                            //右旋pNode
                            rightBlance(pNode);
                            lNode.left.color = ColorModel.BLACK;
                        } else if (lNode.left == NIL && lNode.right != NIL) {//lNode.right为红色
                            //右旋lNode 左旋pNode
                            leftBlance(lNode);
                            rightBlance(pNode);
                            lNode.color = ColorModel.BLACK;
                        } else if (lNode.left != NIL && lNode.right != NIL) {//lNode.left为红色 lNode.right为红色
                            //右旋lNode 左旋pNode
                            leftBlance(lNode);
                            rightBlance(pNode);
                            lNode.color = ColorModel.BLACK;
                        }
                    } else {//lNode必存在两个黑色孩子
                        //右旋pNode
                        rightBlance(pNode);
                    }
                }
            }
        }
        resetNode(parent);
        return new Swap(false, parent.data);
    }

    //右子树最小值
    private Swap swapRightNode(Node parent) {
        return null;
    }


    private void resetNode(Node parent) {
        if (parent != null) {
            parent.parent = null;
            parent.right = null;
            parent.left = null;
        }
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


    private class Swap {
        private boolean isSwap;
        private T data;

        public Swap(boolean isSwap, T data) {
            this.isSwap = isSwap;
            this.data = data;
        }

        public boolean isSwap() {
            return isSwap;
        }

        public T getData() {
            return data;
        }
    }
}
