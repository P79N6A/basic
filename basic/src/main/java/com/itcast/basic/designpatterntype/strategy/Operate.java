package com.itcast.basic.designpatterntype.strategy;

/**
 * Created by qfl on 16/6/3.
 */
public interface Operate<T extends Number> {
    T operate(T a, T b);
}
