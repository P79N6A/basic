package com.itcast.basic.designpatterntype.memento;

public class MementoServiceClient {
    public static void main(String[] args) {
        try {
            Originator originator = new Originator();
            CareTaker careTaker = new CareTaker();
            originator.setStatus("State #1");
            careTaker.add(originator.saveStatusToMemento());
            originator.setStatus("State #2");
            careTaker.add(originator.saveStatusToMemento());
            originator.setStatus("State #3");
            careTaker.add(originator.saveStatusToMemento());
            originator.setStatus("State #4");

            System.out.println("Current State: " + originator.getStatus());
            originator.getStatusFromMemento(careTaker.get(0));
            System.out.println("First saved State: " + originator.getStatus());
            originator.getStatusFromMemento(careTaker.get(1));
            System.out.println("Second saved State: " + originator.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}