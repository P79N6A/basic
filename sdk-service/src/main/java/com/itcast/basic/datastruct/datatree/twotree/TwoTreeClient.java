package com.itcast.basic.datastruct.datatree.twotree;

import java.util.Random;

/**
 * Created by treey.qian on 2017/12/11.
 */
public class TwoTreeClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into TwoTreeClient");
            DataTwoTree<Integer> integerDataTwoTree = new DataTwoTree<>();
            Random random = new Random();
            for (int i = 0; i < 30; i++) {
                integerDataTwoTree.addNode(random.nextInt(100));
            }
            integerDataTwoTree.preOrderDispaly();
            System.out.println("size is " + integerDataTwoTree.size());
        } catch (Exception e) {
            System.out.println("error message is" + e);
        }
    }
}
