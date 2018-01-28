package com.itcast.basic.designpatterntype.factorytype.abstractfactory.factory;

import com.itcast.basic.designpatterntype.factorytype.abstractfactory.abstractfactory.AbstractFactory;
import com.itcast.basic.designpatterntype.factorytype.abstractfactory.abstractproduct.ProductE;
import com.itcast.basic.designpatterntype.factorytype.abstractfactory.abstractproduct.ProductF;
import com.itcast.basic.designpatterntype.factorytype.abstractfactory.product.OMSProductE;
import com.itcast.basic.designpatterntype.factorytype.abstractfactory.product.OMSProductF;

/**
 * Created by qfl on 16/6/2.
 */
public class ProductFactoryA implements AbstractFactory {
    @Override
    public ProductE createProductE() {
        return new OMSProductE();
    }

    @Override
    public ProductF createProductF() {
        return new OMSProductF();
    }
}
