package com.itcast.basic.jdk.rpc.provider;

/**
 * Created by treey.qian on 2018/4/3.
 */
public class ServiceProviderMain {

    public static void main(String[] args) {
        try {
            System.out.println("enter into ServiceProviderMain");
            new ServiceProvider().listen(8888);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
