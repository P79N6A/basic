package com.itcast.basic.designpatterntype.nullobject;

import com.itcast.basic.designpatterntype.nullobject.service.AbstractCustomer;

public class NullObjectServiceClient {
    public static void main(String[] args) {

        try {
            AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
            AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
            AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
            AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

            System.out.println("Customers");
            System.out.println(customer1.getName());
            System.out.println(customer2.getName());
            System.out.println(customer3.getName());
            System.out.println(customer4.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}