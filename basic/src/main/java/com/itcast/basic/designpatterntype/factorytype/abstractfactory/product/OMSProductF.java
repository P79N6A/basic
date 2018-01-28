package com.itcast.basic.designpatterntype.factorytype.abstractfactory.product;

import com.itcast.basic.designpatterntype.factorytype.abstractfactory.abstractproduct.ProductF;

/**
 * Created by qfl on 16/6/2.
 */
public class OMSProductF implements ProductF {
    @Override
    public void operateProductFCore() {
        System.out.println("operate OMSProductF");
    }
}
