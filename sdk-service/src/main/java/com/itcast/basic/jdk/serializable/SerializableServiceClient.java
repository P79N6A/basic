package com.itcast.basic.jdk.serializable;

import java.io.*;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class SerializableServiceClient {

    public static void main(String[] args) {
        try {
            System.out.println("enter into SerializableServiceClient");
            Person person = new Person();
            person.setId(1);
            person.setName("admin");
            person.setAge(22);
            person.setSex(Sex.WOMAN);
            PersonInfo personInfo = new PersonInfo();
            personInfo.setAddress("wuhan");
            personInfo.setJob("computer");
            personInfo.setSchool("wuhan");
            person.setPersonInfo(personInfo);
            writeObject(person);
            System.out.println((String) readObject());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error message is {}" + e);
        }
    }

    private static void writeObject(Object object) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\a.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

    private static <T> T readObject() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("E:\\a.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        T object = (T) objectInputStream.readObject();
        objectInputStream.close();
        return object;
    }


}
