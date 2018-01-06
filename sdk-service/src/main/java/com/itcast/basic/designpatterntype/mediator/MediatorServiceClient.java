package com.itcast.basic.designpatterntype.mediator;

public class MediatorServiceClient {
    public static void main(String[] args) {
        try {
            User robert = new User("Robert");
            User john = new User("John");

            robert.sendMessage("Hi! John!");
            john.sendMessage("Hello! Robert!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}