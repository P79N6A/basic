package com.itcast.basic.designpatterntype.nullobject;

import com.itcast.basic.designpatterntype.nullobject.impl.NullCustomer;
import com.itcast.basic.designpatterntype.nullobject.impl.RealCustomer;
import com.itcast.basic.designpatterntype.nullobject.service.AbstractCustomer;

public class CustomerFactory {

    public static final String[] names = {"Rob", "Joe", "Julie"};

    public static AbstractCustomer getCustomer(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}