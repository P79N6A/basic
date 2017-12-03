package com.itcast.basic.datastruct.datacollection;

/**
 * Created by Administrator on 2017/12/3.
 */
public class DataCollectionClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into DataCollection client");
            DataCollection<String> dataCollection = new DataCollection(new String[]{"admin", "root"});
            dataCollection.addElemet("root");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
