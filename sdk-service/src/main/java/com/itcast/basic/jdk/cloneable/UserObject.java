package com.itcast.basic.jdk.cloneable;

/**
 * Created by Administrator on 2018/2/3.
 */
public class UserObject implements Cloneable {

    private String name;

    private Address address;

    private School school;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        UserObject userObject= (UserObject) super.clone();
        userObject.address= (Address) address.clone();
        return userObject;
    }

    @Override
    public String toString() {
        return "UserObject{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", school=" + school +
                '}';
    }
}
