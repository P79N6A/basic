package com.itcast.basic.datastruct.datatree.redblacktree;

/**
 * Created by treey.qian on 2018/3/8.
 */
public class RBTreeClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into RBTreeClient");
            //5,20,15,35,28,3,10
            RBTree<Integer> rbTree = new RBTree();
//            rbTree.addNode(5);
//            rbTree.addNode(20);
//            rbTree.addNode(15);
//            rbTree.addNode(35);
//            rbTree.addNode(28);
//            rbTree.addNode(2);
//            rbTree.addNode(10);
//            rbTree.addNode(3);
//            rbTree.addNode(7);

            //10,5,20,15,30,14,16,25,35,17,13
//            rbTree.addNode(10);
//            rbTree.addNode(5);
//            rbTree.addNode(20);
//            rbTree.addNode(15);
//            rbTree.addNode(30);
//            rbTree.addNode(14);
//            rbTree.addNode(16);
//            rbTree.addNode(25);
//            rbTree.addNode(35);
//            rbTree.addNode(17);
//            rbTree.addNode(13);
            rbTree.preDisplay();
//            rbTree.removeNode(10);
//            rbTree.preDisplay();
//            rbTree.midDisplay();
//            rbTree.postDisplay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
