package com.itcast.basic.datastruct.datatree.balancetree;

/**
 * Created by treey.qian on 2017/12/27.
 */
public class BalanceTwoTreeClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into BalanceTwoTreeClient");
//            DataTwoTree dataTwoTree = new DataTwoTree();
//            dataTwoTree.addNode(10);
//            dataTwoTree.addNode(20);
//            dataTwoTree.addNode(11);
//            dataTwoTree.addNode(9);
//            dataTwoTree.addNode(8);
//            dataTwoTree.addNode(6);
//            dataTwoTree.addNode(4);
//            dataTwoTree.preOrderDispaly();
//            System.out.println("********************************************");
            DataBalanceTwoTree dataBalanceTwoTree = new DataBalanceTwoTree();
            dataBalanceTwoTree.addNode(10);
            dataBalanceTwoTree.addNode(20);
            dataBalanceTwoTree.addNode(11);
            dataBalanceTwoTree.addNode(9);
            dataBalanceTwoTree.addNode(8);
            dataBalanceTwoTree.addNode(6);
            dataBalanceTwoTree.addNode(4);
            dataBalanceTwoTree.preOrderDisplay();
//            dataBalanceTwoTree.midOrderDisplay();
//            dataBalanceTwoTree.postOrderDisplay();
            System.out.println("****************************************************************************");
            DataBalanceTwoTree.Node node = dataBalanceTwoTree.findNode(11);
            if (node != null) {
                System.out.println("node is " + node + " parent=" + node.getParent() +
                        " left=" + node.getLeft() + " right=" + node.getRight());
            }
        } catch (Exception e) {
            System.out.println("error message is " + e);
        }
    }
}
