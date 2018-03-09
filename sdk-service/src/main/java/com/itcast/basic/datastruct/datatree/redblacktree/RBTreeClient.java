package com.itcast.basic.datastruct.datatree.redblacktree;

/**
 * Created by treey.qian on 2018/3/8.
 */
public class RBTreeClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into RBTreeClient");
            RBTree<Integer> rbTree=new RBTree();
            rbTree.addNode(5);
            rbTree.addNode(20);
            rbTree.addNode(4);
            rbTree.addNode(12);
//            rbTree.addNode(10);
//            rbTree.addNode(15);
            rbTree.preDisplay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
