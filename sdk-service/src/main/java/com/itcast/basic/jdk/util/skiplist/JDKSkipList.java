package com.itcast.basic.jdk.util.skiplist;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by qfl on 2018/4/1.
 */
public class JDKSkipList<K extends Comparable> {
    private final int MAX_LEVEL = 1 << 6;
    private int size;
    private Random random = new Random();
    private final Object INSTANCE = new Object();
    private SkipListNode top;

    public JDKSkipList() {
        top = new SkipListNode(new Node(INSTANCE, INSTANCE, MAX_LEVEL), 0);
    }

    public Object get(K key) {
        assert key != null;
        int curLevel = top.getLevel();
        int i = curLevel - 1;
        //查找插入位置
        while (i >= 0) {
            Node prev = top.getHead().getNext(i);
            while (prev != null) {
                if (key.compareTo(prev.getKey()) == 0) {
                    return prev.getValue();
                }
                prev = prev.getNext(i);
            }
            i--;
        }
        return null;
    }


    public boolean remove(K key) {
        assert key != null;
        int curLevel = top.getLevel();
        Node[] nodes = new Node[curLevel];
        Node prev = top.getHead(), next = null;
        int i = curLevel - 1;
        //查找插入位置
        while (i >= 0) {
            while ((next = prev.getNext(i)) != null && key.compareTo(next.getKey()) != 0) {
                prev = next;
            }
            nodes[i] = prev;
            i--;
        }
        //next指向最底层链表
        if (next == null || (next != null && key.compareTo(next.getKey()) != 0)) {
            return false;
        }
        //逐层删除节点
        for (int j = curLevel - 1; j >= 0; j--) {
            //得到元素
            Node itemNode = nodes[j].nexts[j];
            //itemNode为删除节点
            if (itemNode != null && (key.compareTo(itemNode.getKey()) == 0)) {
                //删除节点
                nodes[j].nexts[j] = itemNode.nexts[j];
                //help GC
                itemNode.nexts[j] = null;
                //被删除节点位于顶层且该层只有一个节点
                if (top.getHead().nexts[j] == null) {
                    top.setLevel(curLevel - 1);
                }
            }
        }
        size--;
        return true;
    }

    public Object put(K key, Object value) {
        assert key != null;
        Node[] nodes = new Node[MAX_LEVEL];
        int curLevel = top.getLevel();
        Node prev = top.getHead(), next = null;
        int i = MAX_LEVEL - 1;
        //查找插入位置
        while (i >= 0) {
            while ((next = prev.getNext(i)) != null && key.compareTo(next.getKey()) > 0) {
                prev = next;
            }
            nodes[i] = prev;
            i--;
        }
        //key已存在直接更新
        if (next != null && key.compareTo(next.getKey()) == 0) {
            Object old = next.getValue();
            next.setValue(value);
            return old;
        }
        //获取随机层
        int level = initLevel();
        if (level > curLevel) {
            //构造插入层
            for (int j = curLevel; j < level; j++) {
                nodes[j] = top.getHead();
            }
            top.setLevel(level);
        }
        //初始化被插入节点
        Node newNode = new Node(key, value, level);
        //调整跳表
        for (int k = level - 1; k >= 0; k--) {
            newNode.nexts[k] = nodes[k].nexts[k];
            nodes[k].nexts[k] = newNode;
        }
        size++;
        return null;
    }

    @Override
    public String toString() {
        int currLevel = top.getLevel();
        StringBuilder stringBuilder = new StringBuilder("skiplist is { size=")
                .append(size)
                .append(" level=")
                .append(currLevel)
                .append(" values is [\n ");
        for (int i = currLevel - 1; i >= 0; i--) {
            Node node = top.getHead().nexts[i];
            while (node != null) {
                stringBuilder.append("[ key=")
                        .append(node.getKey())
                        .append(" value=")
                        .append(node.getValue())
                        .append(" ]").append(" ==> ");
                node = node.nexts[i];
            }
            stringBuilder.append("\n")
                    .append("|")
                    .append("\n")
                    .append("|");
        }

        return stringBuilder.append("] ").append(" }").toString();
    }

    public int size() {
        return size;
    }

    //随机生成层数
    private int initLevel() {
        int level = 1;
        while (random.nextInt() % 2 == 0) {
            level++;
        }
        return level > MAX_LEVEL ? MAX_LEVEL : level;
    }

    //跳表头
    private class SkipListNode {
        private Node head;
        private int level;

        public SkipListNode(Node head, int level) {
            this.head = head;
            this.level = level;
        }

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }

    //跳表节点
    private class Node<K> {
        private K key;
        private Object value;
        private Node[] nexts;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", nexts=" + Arrays.toString(nexts) +
                    '}';
        }

        public Node(K key, Object value, int size) {
            this.key = key;
            this.value = value;
            this.nexts = new Node[size];
        }

        public Object getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node[] getNexts() {
            return nexts;
        }

        public void setNexts(Node[] nexts) {
            this.nexts = nexts;
        }

        public Node getNext(int index) {
            return nexts[index];
        }
    }
}
