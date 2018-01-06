package com.itcast.basic.designpatterntype.observer;

import com.itcast.basic.designpatterntype.observer.impl.BinaryObserver;
import com.itcast.basic.designpatterntype.observer.impl.HexaObserver;
import com.itcast.basic.designpatterntype.observer.impl.OctalObserver;

public class ObserverServiceClient {
    public static void main(String[] args) {
        try {
            Subject subject = new Subject();

            new HexaObserver(subject);
            new OctalObserver(subject);
            new BinaryObserver(subject);

            System.out.println("First state change: 15");
            subject.setState(15);

            System.out.println("Second state change: 10");
            subject.setState(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}