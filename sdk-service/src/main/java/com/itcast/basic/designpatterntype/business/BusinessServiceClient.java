package com.itcast.basic.designpatterntype.business;

public class BusinessServiceClient {

    public static void main(String[] args) {

        try {
            BusinessDelegate businessDelegate = new BusinessDelegate();
            Client client = new Client(businessDelegate);

            businessDelegate.setServiceType("EJB");
            client.doTask();

            businessDelegate.setServiceType("JMS");
            client.doTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}