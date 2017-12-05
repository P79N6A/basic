package com.itcast.basic.datastruct.datacollection;

/**
 * Created by Administrator on 2017/12/3.
 */
public class DataCollectionClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DataCollection client");
            DataCollection<String> dataCollection = new DataCollection(new String[]{"admin", "root", "lily"});
            dataCollection.add(0, "root");
            dataCollection.removeElement("root");
            dataCollection.removeElements(new String[]{"admin", "liluy", "lucy", "tom"});
            dataCollection.display();
            System.out.println("size is " + dataCollection.size());
            dataCollection = new DataCollection();
            for (int i = 0; i < 30; i++) {
                dataCollection.addElemet(i + "");
            }
            dataCollection.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
