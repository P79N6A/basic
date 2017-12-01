package com.itcast.basic.designpatterntype.nullobject.impl;

import com.itcast.basic.designpatterntype.nullobject.service.AbstractCustomer;

public class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isNil() {
        return false;
    }
}