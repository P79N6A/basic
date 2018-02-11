package com.itcast.basic.datastruct.datatree.ordtree;

/**
 * Created by treey.qian on 2017/12/11.
 */
public class TwoTreeClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into TwoTreeClient");
            DataTwoTree<Integer> integerDataTwoTree = new DataTwoTree<>();
            integerDataTwoTree.addNode(12);
            integerDataTwoTree.addNode(50);
            integerDataTwoTree.addNode(10);
            integerDataTwoTree.addNode(3);
            integerDataTwoTree.addNode(8);
            integerDataTwoTree.addNode(5);
            integerDataTwoTree.addNode(9);
            integerDataTwoTree.addNode(4);
            integerDataTwoTree.addNode(6);
            integerDataTwoTree.addNode(7);
            integerDataTwoTree.addNode(11);
//            Random random = new Random();
//            for (int i = 0; i < 10; i++) {
//                integerDataTwoTree.addNode(random.nextInt(100));
//            }
            integerDataTwoTree.preOrderDispaly();
//            integerDataTwoTree.midOrderDispaly();
//            integerDataTwoTree.postOrderDispaly();
            integerDataTwoTree.removeNode(3);
            System.out.println("size is " + integerDataTwoTree.size());
            integerDataTwoTree.preOrderDispaly();
//            integerDataTwoTree.midOrderDispaly();
//            integerDataTwoTree.postOrderDispaly();
            DataTwoTree.Node node = integerDataTwoTree.findNode(5);
            System.out.println("node is " + node + " right is " + node.getRight()
                    + " parent is " + node.getParent() + " left is " + node.getLeft());
//            List<String> stringList = Arrays.asList(new String[]{"java", "ruby", "spark", "c", "c++", "c#", "swift"});
//            DataTwoTree<String> stringDataTwoTree = new DataTwoTree<>();
//            for (String s : stringList) {
//                stringDataTwoTree.addNode(s);
//            }
//            stringDataTwoTree.preOrderDispaly();
//            stringDataTwoTree.midOrderDispaly();
//            stringDataTwoTree.postOrderDispaly();
//            System.out.println("size is " + stringDataTwoTree.size());
        } catch (Exception e) {
            System.out.println("error message is " + e);
        }
    }
}
