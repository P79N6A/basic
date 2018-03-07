package com.itcast.basic.datastruct.datatree.heap;

import com.itcast.basic.datastruct.datatree.completetree.CompleteTree;

/**
 * Created by treey.qian on 2017/12/11.
 */
public class DataHeapClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into DataHeapClient");
            DataHeap dataHeap=new DataHeap();
            dataHeap.addMinHeapNode(4);
            dataHeap.addMinHeapNode(6);
            dataHeap.addMinHeapNode(8);
            dataHeap.addMinHeapNode(5);
            dataHeap.addMinHeapNode(9);
            dataHeap.addMinHeapNode(10);
            dataHeap.preOrderDispaly();
        } catch (Exception e) {
            System.out.println("error message is " + e);
            e.printStackTrace();
        }
    }
}
