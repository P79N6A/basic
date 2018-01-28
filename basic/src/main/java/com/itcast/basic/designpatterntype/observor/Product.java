package com.itcast.basic.designpatterntype.observor;

/**
 * Created by qfl on 16/6/3.
 */
public interface Product {
    void addObservor(Observor observor);

    void removeObservor(Observor observor);

    void notifyObservor();

    void operate();
}
