package com.itcast.basic.jdk.rpc.customer;

import com.itcast.basic.jdk.rpc.service.UserService;

import java.net.InetSocketAddress;

/**
 * Created by treey.qian on 2018/4/3.
 */
public class ServiceCustomerMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into ServiceCustomerMain");
            ServiceCustomer serviceCustomer = new ServiceCustomer();
            UserService userService = (UserService) serviceCustomer.customer(UserService.class, new InetSocketAddress(8888), "userServiceImpl");
            Object result = userService.select();
            System.out.println("result=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
