package com.itcast.basic.io.inputandoutputstream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by qfl on 16/4/28.
 */
public class Person implements Serializable {

    private String name;
    private int id;

    public Person(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "[" + name + "," + id + "]";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    private void writeObject(ObjectOutputStream os) {
        try {
            os.defaultWriteObject();
            System.out.println("序列化成功。");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream is) {
        try {
            is.defaultReadObject();
            System.out.println("反序列化成功。");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
