package com.itcast.basic.nettype;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by qfl on 16/5/2.
 */
public class TestMain {
    public static void main(String[] args) {
        try {
            InetAddress[] inetAddress = InetAddress.getAllByName("www.baidu.com");
            for (InetAddress address : inetAddress) {
                System.out.println(address);
            }
            System.out.println(InetAddress.getByName("www.baidu.com"));
            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        HttpUtils.doGet("http://www.baidu.com");
    }
}
