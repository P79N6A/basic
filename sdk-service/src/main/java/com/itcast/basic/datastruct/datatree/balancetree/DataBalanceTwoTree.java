package com.itcast.basic.datastruct.datatree.balancetree;

import com.itcast.basic.datastruct.datatree.ElectoralModel;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/12/27.
 * 平衡二叉排序树
 */
public class DataBalanceTwoTree<T extends Comparable> implements Serializable {

    private Node root;
    private transient int size;
    private ElectoralModel defaultElectoralModel = ElectoralModel.LEFT;

    /**
     * 插入节点
     *
     * @param data 节点信息
     * @return
     */
    public synchronized boolean addNode(T data) {
        boolean isSuccess = false;
        try {
            if (data == null) {
                throw new IllegalArgumentException("data is not valid");
            }
            if (root == null) {
                root = new Node(null, data, 0);
            } else {
                createNode(root, data);
            }
        } catch (Exception e) {
            System.out.println("DataBalanceTwoTree.addNode error message is " + e);
        }
        return isSuccess;
    }

    private boolean createNode(Node parent, T data) {
        //parent父节点平衡因子是否需要改变
        boolean isRotate = false;

        if (parent != null) {
            int result = data.compareTo(parent.getData());
            if (result >= 0) {
                //插入右子树 不需要旋转
                if (parent.right == null) {
                    //右子树
                    parent.right = new Node(parent, data, 0);
                    size++;
                    //parent.right == null ===>  parent.bFactor in (0,1)
                    //parent.left == null  ===>  parent.bFactor==0
                    if (parent.bFactor == 0) {
                        //右子树插入前 parent平衡 右子树插入后 parent平衡 但需要调整parent父辈节点(从parent到root节点经过节点)平衡因子为-1
                        parent.setbFactor(-1);
                        System.out.println("插入right节点data=" + data + " 父节点parent=" + parent);
                        return true;
                    }
                    //右子树插入前 parent平衡 右子树插入后parent平衡 但无需调整parent父辈节点(从parent到root节点经过节点)平衡因子
                    parent.bFactor = 0;
                    System.out.println("插入right节点data=" + data + " 父节点parent=" + parent);
                } else {
                    //递归右子树
                    isRotate = createNode(parent.right, data);
                    //isRotate==true ===> parent右子树增高 需要调整parent父辈节点(从parent到root节点经过节点)平衡因子
                    if (isRotate) {
                        if (parent.bFactor == 0) {
                            // 节点插入前 parent左右子树高度相同
                            // 节点插入后 parent右子树增高(+1)但parent仍平衡 平衡因子为-1需要调整parent父辈节点(从parent到root节点经过节点)平衡因子
                            parent.setbFactor(-1);
                            isRotate = true;
                        } else if (parent.bFactor == 1) {
                            // 节点插入前 parent左子树高于右子树
                            // 节点插入后 parent右子树增高(+1) parent仍平衡 平衡因子为0 无需调整parent父辈节点(从parent到root节点经过节点)平衡因子
                            parent.setbFactor(0);
                            isRotate = false;
                        } else if (parent.bFactor == -1) {
                            //节点插入前 parent右子树高于左子树 节点插入后 parent右子树再次高于左子树 需要左旋转parent保持平衡
                            leftBalance(parent);
                            isRotate = false;
                            System.out.println("节点左平衡后:" + parent);
                        }
                    }
                }
            } else {
                //插入左子树 不需要旋转
                if (parent.left == null) {
                    //左子树
                    parent.left = new Node(parent, data, 0);
                    size++;
                    //parent.left == null ===> parent.bFactor in (0,-1)
                    //parent.right == null ===> parent.bFactor==0
                    if (parent.bFactor == 0) {
                        //左子树插入前 parent左右子树高度相同
                        //左子树插入后 parent左子树增高(+1)但parent仍平衡 平衡因子为1 需要调整parent父辈节点(从parent到root节点经过节点)平衡因子
                        parent.setbFactor(1);
                        System.out.println("插入left节点data=" + data + " 父节点parent=" + parent);
                        return true;
                    }
                    //左子树插入前 parent右子树高于左子树
                    //左子树插入后 parent仍平衡 且无需调整parent父辈节点(从parent到root节点经过节点)平衡因子
                    parent.bFactor = 0;
                } else {
                    //递归左子树
                    isRotate = createNode(parent.left, data);
                    //isRotate==true ===> parent左子树增高 需要调整parent父辈节点(从parent到root节点经过节点)平衡因子
                    if (isRotate) {
                        if (parent.bFactor == 0) {
                            //节点插入前 parent左右子树高度相同
                            //节点插入后 parent左子树增高(+1)但parent仍平衡 平衡因子为1 需要调整parent父辈节点(从parent到root节点经过节点)平衡因子
                            parent.setbFactor(1);
                            isRotate = true;
                        } else if (parent.bFactor == -1) {
                            //节点插入前 parent右子树高于左子树
                            //节点插入后 parent左子树增高(+1)但parent仍平衡 平衡因子为0 无需调整parent父辈节点(从parent到root节点经过节点)平衡因子
                            parent.setbFactor(0);
                            isRotate = false;
                        } else if (parent.bFactor == 1) {
                            //节点插入前 parent 左子树高于右子树 节点插入后 parent左子树再次高于右子树 需要右旋转parent保持平衡
                            rightBalance(parent);
                            isRotate = false;
                        }
                    }
                }
            }
        }
        return isRotate;
    }

    //右旋
    private void rightBalance(Node node) {
        //右旋节点的左子树必定存在
        Node lNode = node.left;
        if (lNode.bFactor == 1) {
            //右旋转node节点一次保持平衡
            node.bFactor = 0;
            lNode.bFactor = 0;
            rightRotate(node);
        } else if (lNode.bFactor == -1) {
            Node rNode = lNode.right;
            switch (rNode.bFactor) {
                case 0:
                    node.bFactor = 0;
                    lNode.bFactor = 0;
                    break;
                case 1:
                    node.bFactor = -1;
                    rNode.bFactor = 0;
                    lNode.bFactor = 0;
                    break;
                case -1:
                    node.bFactor = 0;
                    lNode.bFactor = 1;
                    rNode.bFactor = 0;
                    break;
            }
            leftRotate(lNode);
            rightRotate(node);
        }

    }

    //右旋重构版
    private void rightRotate(Node node) {
        //右旋节点的左子树必定存在
        Node lNode = node.left;
        //断开旋转节点与左子树的连接
        node.left = lNode.right;
        if (lNode.right != null) {
            lNode.right.parent = node;
        }
        //将旋转节点左子树的父节点连接到旋转节点的父节点
        lNode.parent = node.parent;
        if (node.parent != null) {
            //将旋转节点父节点的子树连接到旋转节点的左子树
            if (node.parent.right == node) {
                node.parent.right = lNode;
            } else {
                node.parent.left = lNode;
            }
        } else {
            root = lNode;
        }
        //将旋转节点的父节点置为旋转节点的左子树
        lNode.right = node;
        node.parent = lNode;
        System.out.println("节点右平衡后:" + node);
    }

    @Deprecated
    private void rightRotate0(Node node) {
        //右旋节点的左子树必定存在
        Node lNode = node.left;
        if (lNode.right == null) {
            //断开旋转节点与左子树的连接
            node.left = null;
            //将旋转节点左子树的父节点连接到旋转节点的父节点
            lNode.parent = node.parent;
            if (node.parent != null) {
                //将旋转节点父节点的子树连接到旋转节点的左子树
                if (node.parent.right == node) {
                    node.parent.right = lNode;
                } else {
                    node.parent.left = lNode;
                }
            } else {
                root = lNode;
            }
            //将旋转节点的父节点置为旋转节点的左子树
            node.parent = lNode;
            //将旋转节点置为旋转节点左子树的右子树
            lNode.right = node;
        } else {
            node.left = lNode.right;
            lNode.parent = node.parent;
            if (node.parent != null) {
                if (node.parent.right == node) {
                    node.parent.right = lNode;
                } else {
                    node.parent.left = lNode;
                }
            } else {
                root = lNode;
            }
            lNode.right.parent = node;
            node.parent = lNode;
            lNode.right = node;
        }
    }

    //左旋
    private void leftBalance(Node node) {
        //左旋节点的右子树必存在
        Node rNode = node.right;
        if (rNode.bFactor == -1) {
            //左旋一次平衡
            node.bFactor = 0;
            rNode.bFactor = 0;
            leftRotate(node);
        } else if (rNode.bFactor == 1) {
            Node lNode = rNode.left;
            switch (lNode.bFactor) {
                case 0:
                    node.bFactor = 0;
                    rNode.bFactor = 0;
                    break;
                case 1:
                    rNode.bFactor = 0;
                    lNode.bFactor = 0;
                    node.bFactor = 1;
                    break;
                case -1:
                    node.bFactor = 0;
                    lNode.bFactor = 0;
                    rNode.bFactor = -1;
                    break;
            }
            rightRotate(rNode);
            leftRotate(node);
        }
    }

    //左旋重构简化版
    private void leftRotate(Node node) {
        //左旋节点的右子树必定存在
        Node rNode = node.right;
        //将旋转节点右子树根节点的左子树置为旋转节点
        node.right = rNode.left;
        if (rNode.left != null) {
            rNode.left.parent = node;
        }
        //将旋转节点右子树根节点的父节点连接到旋转节点的父节点
        rNode.parent = node.parent;
        if (node.parent != null) {
            if (node.parent.left == node) {
                //将旋转节点的父节点的左子树置为旋转节点右子树的根节点
                node.parent.left = rNode;
            } else {
                //将旋转节点的父节点的右子树置为旋转节点的右子树的根节点
                node.parent.right = rNode;
            }
        } else {
            root = rNode;
        }
        //将旋转节点置为其右子树根节点的左子树
        rNode.left = node;
        node.parent = rNode;
        System.out.println("节点左平衡后:" + node);
    }

    @Deprecated
    private void leftRotate0(Node node) {
        //左旋节点的右子树必定存在
        Node rNode = node.right;
        if (rNode.left == null) {
            //断开旋转节点与右子树连接
            node.right = null;
            //将旋转节点右子树父节点连接到旋转节点父节点
            rNode.parent = node.parent;
            if (node.parent != null) {
                //将旋转节点子树连接到旋转节点右子树
                if (node.parent.left == node) {
                    node.parent.left = rNode;
                } else {
                    node.parent.right = rNode;
                }
            } else {
                root = rNode;
            }
            //将旋转节点父节点置为旋转节点右子树根节点
            node.parent = rNode;
            //将旋转节点置为旋转节点右子树顶点的左子树
            rNode.left = node;
        } else {
            node.right = rNode.left;
            rNode.parent = node.parent;
            if (node.parent != null) {
                if (node.parent.left == node) {
                    node.parent.left = rNode;
                } else {
                    node.parent.right = rNode;
                }
            } else {
                root = rNode;
            }
            rNode.left.parent = node;
            node.parent = rNode;
            rNode.left = node;
        }
    }

    public synchronized int size() {
        return size;
    }

    //前序遍历 根左右
    public synchronized void preOrderDisplay() {
        StringBuilder stringBuilder = new StringBuilder();
        preOrderDisplay(stringBuilder, root);
        System.out.println("preOrderDisplay tree is " + stringBuilder.toString());
    }

    private void preOrderDisplay(StringBuilder stringBuilder, Node parent) {
        if (parent != null) {
            stringBuilder.append(parent);

            if (parent.left != null) {
                stringBuilder.append(" ---> ");
                preOrderDisplay(stringBuilder, parent.left);
            }

            if (parent.right != null) {
                stringBuilder.append(" ---> ");
                preOrderDisplay(stringBuilder, parent.right);
            }
        }
    }

    //中序遍历 左根右
    public synchronized void midOrderDisplay() {
        StringBuilder stringBuilder = new StringBuilder();
        midOrderDisplay(stringBuilder, root);
        System.out.println("midOrderDisplay tree is " + stringBuilder.substring(0, stringBuilder.lastIndexOf("--->")).toString());
    }

    public void midOrderDisplay(StringBuilder stringBuilder, Node parent) {
        if (parent != null) {
            if (parent.left != null) {
                midOrderDisplay(stringBuilder, parent.left);
            }

            stringBuilder.append(parent);
            stringBuilder.append(" ---> ");

            if (parent.right != null) {
                midOrderDisplay(stringBuilder, parent.right);
            }

        }
    }

    //后序遍历
    public synchronized void postOrderDisplay() {
        StringBuilder stringBuilder = new StringBuilder();
        postOrderDisplay(stringBuilder, root);
        System.out.println("postOrderDisplay tree is " + stringBuilder.substring(0, stringBuilder.lastIndexOf("--->")).toString());
    }

    private void postOrderDisplay(StringBuilder stringBuilder, Node parent) {
        if (parent != null) {
            if (parent.left != null) {
                postOrderDisplay(stringBuilder, parent.left);
            }

            if (parent.right != null) {
                postOrderDisplay(stringBuilder, parent.right);
            }

            stringBuilder.append(parent).append(" ---> ");
        }
    }

    /**
     * 节点查找
     *
     * @param data
     * @return
     */
    public synchronized Node findNode(T data) {
        return findNodeWarp(root, data);
    }

    private Node findNodeWarp(Node parent, T data) {
        Node node = null;
        int result = parent.getData().compareTo(data);
        if (result > 0) {
            return findNodeWarp(parent.left, data);
        } else if (result < 0) {
            return findNodeWarp(parent.right, data);
        } else {
            node = new Node(parent.parent, data, parent.bFactor);
            node.left = parent.left;
            node.right = parent.right;
        }
        return node;
    }

    @Override
    public String toString() {
        if (size() > 0) {
            return "tree has " + size() + " nodes please use function display them";
        } else {
            return "tree has no nodes";
        }
    }

    /**
     * 节点删除操作
     *
     * @param data
     */
    public synchronized boolean removeNode(T data) {
        if (findNode(data) != null) {
            swapNode(root, data);
            return true;
        }
        return false;
    }

    private boolean swapNode(Node parent, T data) {
        if (parent != null) {
            int result = parent.getData().compareTo(data);
            if (result > 0) {
                boolean isSwap = swapNode(parent.left, data);
                if (isSwap) {
                    if (parent.bFactor == 1) {
                        parent.setbFactor(0);
                        return true;
                    } else if (parent.bFactor == 0) {
                        parent.setbFactor(-1);
                        return false;
                    } else if (parent.bFactor == -1) {
                        leftBalance(parent);
                        return false;
                    }
                }
            } else if (result < 0) {
                boolean isSwap = swapNode(parent.right, data);
                if (isSwap) {
                    if (parent.bFactor == 1) {
                        rightBalance(parent);
                        return false;
                    } else if (parent.bFactor == 0) {
                        parent.setbFactor(1);
                        return false;
                    } else if (parent.bFactor == -1) {
                        parent.setbFactor(0);
                        return true;
                    }
                }
            } else {
                Node pNode = parent.parent;
                parent.parent = null;
                //叶子节点
                if (parent.left == null && parent.right == null) {
                    if (pNode != null) {
                        if (pNode.left == parent) {
                            pNode.left = null;
                        } else {
                            pNode.right = null;
                        }
                        return true;
                    } else {
                        root = null;
                    }
                } else if (parent.left != null && parent.right != null) {
                    Swap swap;
                    switch (defaultElectoralModel.getIndex()) {
                        case 0:
                            //左子树最大值
                            swap = swapLeftNode(parent);
                            parent.data = swap.data;
                            return swap.isSwap;
                        case 1:
                            //右子树最小值
                            swap = swapRightNode(parent);
                            parent.data = swap.data;
                            return swap.isSwap;
                    }
                } else if (parent.left != null) {
                    Node lNode = parent.left;
                    if (pNode != null) {
                        parent.left = null;
                        lNode.parent = pNode;
                        if (pNode.left == parent) {
                            pNode.left = lNode;
                        } else {
                            pNode.right = lNode;
                        }
                        return true;
                    } else {
                        lNode.parent = null;
                        pNode.left = null;
                        root = lNode;
                    }
                } else if (parent.right != null) {
                    Node rNode = parent.right;
                    if (pNode != null) {
                        parent.right = null;
                        rNode.parent = pNode;
                        if (pNode.left == parent) {
                            pNode.left = rNode;
                        } else {
                            pNode.right = rNode;
                        }
                        return true;
                    } else {
                        rNode.parent = null;
                        pNode.right = null;
                        root = rNode;
                    }
                }
                size--;
            }
        }
        return false;
    }

    private Swap swapLeftNode(Node parent) {
        Node lNode = parent.getLeft();
        boolean isSwap = false;
        //删除左节点lNode
        if (lNode.right == null) {
            if (lNode.left == null) {
                lNode.parent = null;
                parent.left = null;
            } else {
                parent.left = lNode.left;
                lNode.left.parent = parent;
                lNode.parent = null;
                lNode.left = null;
            }
            if (parent.bFactor == -1) {
                leftBalance(parent);
            } else if (parent.bFactor == 0) {
                parent.bFactor = -1;
            } else if (parent.bFactor == 1) {
                parent.bFactor = 0;
                isSwap = true;
            }
            return new Swap(lNode.getData(), isSwap);
        }
        return swapLeftNode0(parent.right);
    }

    private Swap swapLeftNode0(Node parent) {
        if (parent.right == null) {
            boolean isSwap = false;
            if (parent.left == null) {
                parent.parent.right = null;
                parent.parent = null;
            } else {
                parent.parent.right = parent.left;
                parent.left.parent = parent.parent;
                parent.parent = null;
                parent.left = null;
            }
            if (parent.bFactor == -1) {
                parent.bFactor = 0;
                isSwap = true;
            } else if (parent.bFactor == 0) {
                parent.bFactor = 1;
            } else if (parent.bFactor == 1) {
                rightBalance(parent);
            }
            return new Swap(parent.getData(), isSwap);
        } else {
            return swapLeftNode0(parent.right);
        }
    }

    private Swap swapRightNode(Node parent) {
        return null;
    }

    private Swap swapRightNode0(Node parent) {
        return null;
    }

    private class Swap {
        private T data;
        private boolean isSwap = false;

        public Swap(T data, boolean isSwap) {
            this.data = data;
            this.isSwap = isSwap;
        }
    }

    public class Node {
        private T data;
        private Node parent;
        private Node left;
        private Node right;
        //平衡因子(左子树高度减去右子树高度的值)
        private int bFactor;

        public Node(Node parent, T data, int bFactor) {
            this.data = data;
            this.parent = parent;
            this.bFactor = bFactor;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", bFactor=" + bFactor +
                    '}';
        }

        public Node getParent() {
            return parent;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getbFactor() {
            return bFactor;
        }

        public T getData() {
            return data;
        }

        public void setbFactor(int bFactor) {
            this.bFactor = bFactor;
        }
    }
}
