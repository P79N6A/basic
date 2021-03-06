package com.itcast.basic.test.qfl;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Serializable;

/**
 * Created by treey.qian on 2018/1/8.
 */
public class TestDataSplitMain {
    static private final int start = 0;
    static private final int size = 1024;

    public static void main(String[] args) {
        try {
            System.out.println("enter into TestDataSplitMain");
            BufferedReader reader = new BufferedReader(new FileReader("E:\\01.txt"));
            DataTwoTree dataTwoTree = new DataTwoTree<User>();
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (!line.trim().equals("")) {
                    String[] ss = line.split(":");
                    String id = ss[0].trim();
                    String desc = ss[1].trim();
                    dataTwoTree.addNode(new User(id, desc));
                }
            }
            System.out.println("size is " + dataTwoTree.size());
            dataTwoTree.postOrderDispaly();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class User implements Comparable {

    private String id;
    private String desc;
    private StringBuilder stringBuilder = new StringBuilder();

    public User() {
    }

    public User(String id, String desc) {
        this.id = id;
        this.desc = desc;
        this.setStringBuilder(desc);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setStringBuilder(String s) {
        this.stringBuilder.append(s).append("######");
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    @Override
    public int compareTo(Object o) {
        return id.compareTo(((User) o).getId());
    }

    @Override
    public String toString() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\zip\\" + id + ".txt");
            fileOutputStream.write(getStringBuilder().toString().getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "User{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", stringBuilder=" + stringBuilder +
                '}';
    }
}

class DataTwoTree<T extends Comparable> implements Serializable {
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
        int result = data.compareTo(parent.getData());
        if (result < 0) {
            //data<node data ==> function compareTo return -1 搜索左子树
            if (parent.left == null) {
                parent.left = new Node(parent, data);
                size++;
                System.out.println("插入left节点data=" + data + " 父节点data=" + parent.getData());
            } else {
                //开始递归
                createNode(parent.left, data);
            }
        } else if (result > 0) {
            //data>=node data ==> function compareTo return  搜索右子树
            if (parent.right == null) {
                parent.right = new Node(parent, data);
                size++;
                System.out.println("插入right节点data=" + data + " 父节点data=" + parent.getData());
            } else {
                //开始递归
                createNode(parent.right, data);
            }
        } else if (result == 0) {
            if (data instanceof User && parent.data instanceof User) {
                User user = (User) data;
                String desc = user.getDesc();
                user = (User) parent.data;
                user.setStringBuilder(desc);
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

    public synchronized boolean removeNode(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is not valid");
        }
        if (!delNode(data, root)) {
            throw new IllegalArgumentException("data is not exists");
        }
        return true;
    }

    private boolean delNode(T data, Node parent) {
        if (data != null && parent != null) {
            Object nodeData = parent.getData();
            int result = data.compareTo(nodeData);
            if (result > 0) {
                return delNode(data, parent.right);
            } else if (result < 0) {
                return delNode(data, parent.left);
            } else {

                if (parent.left == null && parent.right == null) {
                    //不存在子树
                    Node delParent = parent.parent;
                    if (delParent.left != null && delParent.left.getData().equals(data)) {
                        delParent.left = null;
                    } else if (delParent.right != null && delParent.right.getData().equals(data)) {
                        delParent.right = null;
                    }
                    parent.parent = null;
                    size--;
                } else if (parent.left != null && parent.right != null) {
                    //左右子树均存在(取左子树最大值或右子树最小值)
                    Object swapData = findSwapNode(parent.left, "right");
//                    Object swapData = findSwapNode(parent.right, "left");
                    parent.data = (T) swapData;
                    size--;
                } else if (parent.left != null) {
                    //存在左子树
                    Node delParent = parent.parent;
                    if (delParent.left != null && delParent.left.getData().equals(data)) {
                        delParent.left = parent.left;
                    } else if (delParent.right != null && delParent.right.getData().equals(data)) {
                        delParent.right = parent.left;
                    }
                    parent.left.parent = delParent;
                    parent.left = null;
                    size--;
                } else if (parent.right != null) {
                    //存在右子树
                    Node delParent = parent.parent;
                    if (delParent.left != null && delParent.left.getData().equals(data)) {
                        delParent.left = parent.right;
                    } else if (delParent.right != null && delParent.right.getData().equals(data)) {
                        delParent.right = parent.right;
                    }
                    parent.right.parent = delParent;
                    parent.right = null;
                    size--;
                }
                return true;
            }
        }
        return false;
    }

    private Object findSwapNode(Node parent, String flag) {
        if ("left".equalsIgnoreCase(flag)) {
            if (parent.left == null) {
                parent.parent.right = null;
                parent.parent = null;
                return parent.getData();
            } else {
                return findSwapNode(parent.left, flag);
            }
        } else {
            if (parent.right == null) {
                parent.parent.left = null;
                parent.parent = null;
                return parent.getData();
            } else {
                return findSwapNode(parent.right, flag);
            }
        }
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
