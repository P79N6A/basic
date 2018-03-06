package com.itcast.basic.datastruct.datatree.ordtree;

import com.itcast.basic.datastruct.datatree.ElectoralModel;

import java.io.Serializable;

/**
 * Created by treey.qian on 2017/12/11.
 * 二叉排序树
 */
public class DataTwoTree<T extends Comparable> implements Serializable {
    private Node root;
    private transient int size;
    private ElectoralModel defaultElectoralModel = ElectoralModel.LEFT;

    //加入节点
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

    /**
     * 删除一个节点
     *
     * @param data 要删除节点
     * @return
     */
    public synchronized boolean removeNode(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is not valid");
        }
        return delNode(data, root);
    }

    private boolean delNode(T data, Node parent) {
        if (parent != null) {
            int result = parent.getData().compareTo(data);
            if (result > 0) {
                return delNode(data, parent.left);
            } else if (result < 0) {
                return delNode(data, parent.right);
            } else {
                Node pNode = parent.parent;
                parent.parent = null;
                if (parent.left == null && parent.right == null) {
                    //叶子节点
                    if (pNode != null) {
                        if (pNode.left == parent) {
                            pNode.left = null;
                        } else {
                            pNode.right = null;
                        }
                    } else {
                        root = null;
                    }
                } else if (parent.right != null && parent.left != null) {
                    parent.parent = pNode;
                    switch (defaultElectoralModel.getIndex()) {
                        case 0:
                            //左子树最大值
                            parent.data = swapLeftNode(parent);
                            break;
                        case 1:
                            //右子树最小值
                            parent.data = swapRightNode(parent);
                            break;
                    }
                } else if (parent.left != null) {
                    Node lNode = parent.getLeft();
                    parent.left = null;
                    if (pNode != null) {
                        if (pNode.right == parent) {
                            pNode.right = lNode;
                        } else {
                            pNode.left = lNode;
                        }
                        lNode.parent = pNode;
                    } else {
                        lNode.parent = null;
                        root = lNode;
                    }
                } else if (parent.right != null) {
                    Node rNode = parent.getRight();
                    parent.right = null;
                    if (pNode != null) {
                        if (pNode.right == parent) {
                            pNode.right = rNode;
                        } else {
                            pNode.left = rNode;
                        }
                        rNode.parent = pNode;
                    } else {
                        rNode.parent = null;
                        root = rNode;
                    }
                }
                size--;
            }
        }
        return false;
    }

    private T swapLeftNode(Node parent) {
        Node lNode = parent.left;
        if (lNode.right == null) {
            if (lNode.left == null) {
                parent.left = null;
                lNode.parent = null;
            } else {
                parent.left = lNode.left;
                lNode.left.parent = parent;
                lNode.parent = null;
                lNode.left = null;
            }
            return lNode.getData();
        }
        return swapLeftNode0(lNode.right);

    }

    private T swapLeftNode0(Node parent) {
        if (parent.right == null) {
            if (parent.left == null) {
                parent.parent.right = null;
                parent.parent = null;
            } else {
                parent.parent.right = parent.left;
                parent.left.parent = parent.parent;
                parent.left = null;
                parent.parent = null;
            }
            return parent.getData();
        }
        return swapLeftNode0(parent.right);
    }

    private T swapRightNode(Node parent) {
        Node rNode = parent.right;
        if (rNode.left == null) {
            if (rNode.right == null) {
                rNode.parent = null;
                parent.right = null;
            } else {
                parent.right = rNode.left;
                rNode.left.parent = parent;
                rNode.right = null;
                rNode.parent = null;
            }
            return rNode.getData();
        }
        return swapRightNode0(rNode.left);
    }

    private T swapRightNode0(Node parent) {
        if (parent.left == null) {
            if (parent.right == null) {
                parent.parent.left = null;
                parent.parent = null;
            } else {
                parent.parent.left = parent.right;
                parent.right.parent = parent.parent;
                parent.parent = null;
                parent.left = null;
            }
            return parent.getData();
        }
        return swapRightNode0(parent.left);
    }

    /**
     * 查询节点
     *
     * @param data
     * @return
     */
    public synchronized Node findNode(T data) {
        return findNode(root, data);
    }

    private Node findNode(Node parent, T data) {
        Node node = null;
        if (parent != null) {
            int result = parent.getData().compareTo(data);
            if (result > 0) {
                //查找root 左子树
                node = findNode(parent.left, data);
            } else if (result < 0) {
                //查找root 右子树
                node = findNode(parent.right, data);
            } else {
                node = new Node(parent.parent, parent.getData());
                node.setLeft(parent.left);
                node.setRight(parent.right);
            }
        }
        return node;
    }

    public synchronized int size() {
        return size;
    }

    public ElectoralModel getDefaultElectoralModel() {
        return defaultElectoralModel;
    }

    public void setDefaultElectoralModel(ElectoralModel defaultElectoralModel) {
        this.defaultElectoralModel = defaultElectoralModel;
    }

    @Override
    public String toString() {
        if (size() > 0) {
            return "tree has " + size() + " nodes please use function display them";
        } else {
            return "tree has no nodes";
        }
    }

    public class Node {
        private Node parent;
        private Node left;
        private Node right;
        private T data;

        public Node getParent() {
            return parent;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

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
