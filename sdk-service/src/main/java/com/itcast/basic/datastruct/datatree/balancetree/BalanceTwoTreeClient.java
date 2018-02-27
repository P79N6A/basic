package com.itcast.basic.datastruct.datatree.balancetree;

/**
 * Created by treey.qian on 2017/12/27.
 */
public class BalanceTwoTreeClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into BalanceTwoTreeClient");
            DataBalanceTwoTree dataBalanceTwoTree = new DataBalanceTwoTree();
//            dataBalanceTwoTree.addNode(4);
//            dataBalanceTwoTree.addNode(2);
            dataBalanceTwoTree.addNode(20);
            dataBalanceTwoTree.addNode(15);
            dataBalanceTwoTree.addNode(30);
            dataBalanceTwoTree.addNode(25);
            dataBalanceTwoTree.addNode(35);
//            dataBalanceTwoTree.addNode(22);
//            dataBalanceTwoTree.addNode(12);
//            dataBalanceTwoTree.addNode(14);
//            dataBalanceTwoTree.addNode(21);
//            dataBalanceTwoTree.addNode(11);
//            dataBalanceTwoTree.addNode(19);
//            dataBalanceTwoTree.addNode(27);
//            dataBalanceTwoTree.addNode(35);
//            dataBalanceTwoTree.addNode(23);
//            dataBalanceTwoTree.addNode(40);
            dataBalanceTwoTree.preOrderDisplay();
            dataBalanceTwoTree.removeNode(15);
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
            e.printStackTrace();
        }
    }
}
