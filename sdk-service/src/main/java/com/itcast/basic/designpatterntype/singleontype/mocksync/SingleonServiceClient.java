package com.itcast.basic.designpatterntype.singleontype.mocksync;

import com.itcast.basic.designpatterntype.singleontype.EnumSingleon;
import com.itcast.basic.designpatterntype.singleontype.LazySingleon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class SingleonServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("enter into SingleonServiceClient");
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        new Human().sysHello();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        new Person().sysHello();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();

            System.out.println("i=" + EnumSingleon.SINGLEON.incr());

            FileOutputStream fileOutputStream = new FileOutputStream("E:\\a.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            LazySingleon lazySingleon = LazySingleon.newInstanceByBlock();
            LazySingleon lazySingleon1 = LazySingleon.newInstanceByMethod();
            System.out.println("is same " + (lazySingleon == lazySingleon1));
            objectOutputStream.writeObject(lazySingleon);
            objectOutputStream.flush();
            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("E:\\a.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();

            Object enumObject = Enum.valueOf(EnumSingleon.class, "SINGLEON");

            FileInputStream fileInputStream1 = new FileInputStream("E:\\a.txt");
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
            Object object1 = objectInputStream1.readObject();
            System.out.println("is same " + (object == object1));
//            System.out.println("is same " + (enumObject == object));
//            System.out.println("is same " + (enumObject == object1));
            objectInputStream1.close();

            String lock = "lock";
            synchronized (lock) {
                lock.wait();
            }
        } catch (Exception e) {
            System.out.println("SingleonServiceClient error message is" + e);
        }
    }
}
