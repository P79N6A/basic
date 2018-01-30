package com.itcast.basic.jdk.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 20171128183300l;

    private int id;

    private String name;

    private Sex sex;

    PersonInfo personInfo;

    private transient int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", personInfo=" + personInfo +
                ", age=" + age +
                '}';
    }

    //改写序列化实例
    private Object writeReplace() {
        System.out.println("write replace start");
//        return new Person();
        return this;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException, ClassNotFoundException {
        System.out.println("enter into writeObject");
        objectOutputStream.defaultWriteObject();
        if (sex != null && sex.name().equals(Sex.MAN.name())) {
            objectOutputStream.writeInt(age);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        System.out.println("enter into readObject");
        objectInputStream.defaultReadObject();
        if (sex != null && sex.name().equals(Sex.MAN.name())) {
            age = objectInputStream.readInt();
        }
    }

    //覆盖反序列化对象
    private Object readResolve() {
        System.out.println("read resolve start");
//        return new Person();
        return this;
    }

}
