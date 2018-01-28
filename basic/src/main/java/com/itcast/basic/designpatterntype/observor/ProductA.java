package com.itcast.basic.designpatterntype.observor;

import java.util.Vector;

/**
 * Created by qfl on 16/6/3.
 */
public class ProductA implements Product {
    private Vector<Observor> observors = new Vector<Observor>();

    @Override
    public void addObservor(Observor observor) {
        observors.add(observor);
    }

    @Override
    public void removeObservor(Observor observor) {
        observors.remove(observor);
    }

    @Override
    public void notifyObservor() {

    }

    @Override
    public void operate() {

    }
}
