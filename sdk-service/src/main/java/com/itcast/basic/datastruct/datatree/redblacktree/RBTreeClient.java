package com.itcast.basic.datastruct.datatree.redblacktree;

/**
 * Created by treey.qian on 2018/3/8.
 */
public class RBTreeClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into RBTreeClient");
            RBTree<Integer> rbTree = new RBTree();
            rbTree.addNode(50);
            rbTree.addNode(35);
            rbTree.addNode(78);
            rbTree.addNode(27);
            rbTree.addNode(45);
            rbTree.addNode(56);
            rbTree.addNode(90);
            rbTree.addNode(40);
            rbTree.addNode(48);
//            rbTree.preDisplay();
//            rbTree.midDisplay();
            rbTree.postDisplay();
            System.out.println("node is " + rbTree.findNode(35));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
