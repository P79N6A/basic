package com.itcast.basic.datastruct.datatree.trietree;

import java.util.List;

/**
 * Created by treey.qian on 2018/3/8.
 */
public class TrieTreeClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into TrieTreeClient");
            TrieTree trieTree = new TrieTree();
            trieTree.addNode("adject");
            trieTree.addNode("admin");
            trieTree.addNode("ADMIN");
            trieTree.addNode("admins");
            trieTree.addNode("adminstor");
            trieTree.addNode("adjectation");
            trieTree.addNode("treey");
            trieTree.addNode("lily");
            trieTree.addNode("lucy");
            trieTree.display();
            List<String> elements = trieTree.printElements();
            for (String element : elements) {
                System.out.println("element is " + element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
