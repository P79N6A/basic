package com.itcast.basic.designpatterntype.visitor;

/**
 * Created by qfl on 16/6/3.
 */
public interface Service {
    void accept(Visitor visitor);
}
