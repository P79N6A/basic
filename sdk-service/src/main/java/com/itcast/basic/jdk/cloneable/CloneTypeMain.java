package com.itcast.basic.jdk.cloneable;

/**
 * Created by Administrator on 2018/2/3.
 * 演示深拷贝和浅拷贝
 */
public class CloneTypeMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into CloneTypeMain");
            UserObject userObject = new UserObject();
            userObject.setName("admin");
            Address address = new Address();
            address.setAddress("wuhan");
            School school = new School();
            school.setSchool("qf");

            userObject.setAddress(address);
            userObject.setSchool(school);

            UserObject userObject0 = (UserObject) userObject.clone();
            System.out.println("userObject=" + userObject + " userObject0=" + userObject0);

            userObject0.getSchool().setSchool("rizhao");
            userObject.getAddress().setAddress("zhejiang");
            System.out.println("userObject=" + userObject + " userObject0=" + userObject0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
