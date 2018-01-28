package com.itcast.basic.clonetype;

/**
 * Created by qfl on 16/4/21.
 * java中一般都是浅拷贝 深拷贝需要自己做如下处理
 */
public class CloneDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(111);
        s1.setName("Lily");
        Address address = new Address();
        address.setCity("jinan");
        address.setCode(123456);
        s1.setAddress(address);
        Student student = s1.clone();
        student.setName("Lucy");
        System.out.println("name is " + s1.getName());
    }
}

class Student implements Cloneable {
    private int id;
    private String name;
    private Address address;

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public Student clone() {
        Student student = null;
        try {
            student = (Student) super.clone();
            student.address = address.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;
    }
}

class Address implements Cloneable {
    private long code;
    private String city;

    public long getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCode(long code) {
        this.code = code;
    }

    @Override
    public Address clone() {
        Address address = null;
        try {
            address = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return address;
    }
}
