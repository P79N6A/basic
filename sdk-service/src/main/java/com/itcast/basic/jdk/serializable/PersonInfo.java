package com.itcast.basic.jdk.serializable;

import java.io.*;

/**
 * Created by treey.qian on 2017/11/28.
 */
public class PersonInfo implements Externalizable {

    private static final long serialVersionUID = 20171128204800l;

    private String address;

    private String school;

    private String job;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "address='" + address + '\'' +
                ", school='" + school + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    //该方法在接口Externalizable中无效
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException, ClassNotFoundException {
        System.out.println("enter into PersonInfo writeObject");
        objectOutputStream.defaultWriteObject();
    }

    //该方法在接口Externalizable中无效
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        System.out.println("enter into PersonInfo readObject");
        objectInputStream.defaultReadObject();
    }

    //改写序列化实例
    private Object writeReplace() {
        System.out.println("write PersonInfo replace start");
        return this;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(address);
        out.writeObject(school);
        out.writeObject(job);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        address = in.readObject().toString();
        school = in.readObject().toString();
        job = in.readObject().toString();
    }

    //覆盖反序列化对象
    private Object readResolve() {
        System.out.println("read PersonInfo resolve start");
        return this;
    }
}
