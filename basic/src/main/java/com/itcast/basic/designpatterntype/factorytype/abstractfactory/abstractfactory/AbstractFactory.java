package com.itcast.basic.designpatterntype.factorytype.abstractfactory.abstractfactory;

import com.itcast.basic.designpatterntype.factorytype.abstractfactory.abstractproduct.ProductE;
import com.itcast.basic.designpatterntype.factorytype.abstractfactory.abstractproduct.ProductF;

/**
 * Created by qfl on 16/6/2.
 */
public interface AbstractFactory {
    ProductE createProductE();

    ProductF createProductF();
}
