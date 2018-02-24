package com.itcast.basic.datastruct.datatree.balancetree;

/**
 * Created by treey.qian on 2017/12/27.
 */
public class BalanceTwoTreeClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into BalanceTwoTreeClient");
            DataBalanceTwoTree dataBalanceTwoTree = new DataBalanceTwoTree();
//            dataBalanceTwoTree.addNode(15);
            dataBalanceTwoTree.addNode(10);
            dataBalanceTwoTree.addNode(9);
            dataBalanceTwoTree.addNode(13);
            dataBalanceTwoTree.addNode(16);
//            dataBalanceTwoTree.addNode(22);
//            dataBalanceTwoTree.addNode(18);
//            dataBalanceTwoTree.addNode(7);
            dataBalanceTwoTree.addNode(11);
//            dataBalanceTwoTree.addNode(12);
            dataBalanceTwoTree.preOrderDisplay();
            dataBalanceTwoTree.removeNode(10);
            dataBalanceTwoTree.preOrderDisplay();
//            dataBalanceTwoTree.midOrderDisplay();
//            dataBalanceTwoTree.postOrderDisplay();
//            System.out.println("****************************************************************************");
//            DataBalanceTwoTree.Node node = dataBalanceTwoTree.findNode(8);
//            if (node != null) {
//                System.out.println("node is " + node + " parent=" + node.getParent() +
//                        " left=" + node.getLeft() + " right=" + node.getRight());
//            }
        } catch (Exception e) {
            System.out.println("error message is " + e);
        }
    }
}
