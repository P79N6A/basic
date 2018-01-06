package com.itcast.basic.datastruct.linkedlist.dataonewaylinkedlist;

/**
 * Created by treey.qian on 2017/12/6.
 */
public class LinkListClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into OneWayLinkListClient");
            OneWayLinkList<Integer> oneWayLinkList = new OneWayLinkList<>();
            for (int i = 0; i < 2; i++) {
                oneWayLinkList.addNode(i);
            }
            System.out.println("oneWayLinkList=" + oneWayLinkList);
            oneWayLinkList.display();
            for (int i = 0; i < 9; i++) {
                oneWayLinkList.removeNode(i);
            }
            oneWayLinkList.display();
            System.out.println("size is " + oneWayLinkList.size());
            System.out.println("*********************************************************");
            OneWayLoopLinkList<Integer> oneWayLoopLinkList = new OneWayLoopLinkList();
            for (int i = 0; i < 10; i++) {
                oneWayLoopLinkList.addNode(i);
            }
            oneWayLoopLinkList.display();
            for (int i = 0; i < 9; i++) {
                oneWayLoopLinkList.removeNode(i);
            }
            oneWayLoopLinkList.display();
            System.out.println("size is " + oneWayLoopLinkList.size());
            System.out.println("*********************************************************");
            TwoWayLinkList<Integer> twoWayLinkList = new TwoWayLinkList<>();
            for (int i = 0; i < 10; i++) {
                twoWayLinkList.addNode(i);
            }
            twoWayLinkList.display();
            System.out.println("linkList revert is" + twoWayLinkList.revert());
            for (int i = 0; i < 3; i++) {
                twoWayLinkList.removeNode(i);
            }
            twoWayLinkList.display();
            System.out.println("linkList revert is" + twoWayLinkList.revert());
            System.out.println("*********************************************************");
            TwoWayLoopLinkList<Integer> twoWayLoopLinkList = new TwoWayLoopLinkList();
            for (int i = 0; i < 10; i++) {
                twoWayLoopLinkList.addNode(i);
            }
            twoWayLoopLinkList.display();
            System.out.println(" linkList revert is" + twoWayLoopLinkList.revert());
            for (int i = 0; i < 3; i++) {
                twoWayLoopLinkList.removeNode(i);
            }
            twoWayLoopLinkList.display();
        } catch (Exception e) {
            System.out.println("OneWayLinkListClient error message is" + e);
        }
    }
}
