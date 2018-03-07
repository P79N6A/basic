package com.itcast.basic.datastruct.datatree.completetree;

/**
 * Created by treey.qian on 2017/12/11.
 */
public class CompleteTreeClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into CompleteTreeClient");
            CompleteTree completeTree=new CompleteTree();
            completeTree.addNode(4);
            completeTree.addNode(6);
            completeTree.addNode(8);
            completeTree.addNode(5);
            completeTree.addNode(9);
            completeTree.addNode(10);
            completeTree.preOrderDispaly();
        } catch (Exception e) {
            System.out.println("error message is " + e);
            e.printStackTrace();
        }
    }
}
