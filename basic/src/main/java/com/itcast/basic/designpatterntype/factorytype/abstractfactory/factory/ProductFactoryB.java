package com.itcast.basic.designpatterntype.factorytype.abstractfactory.factory;

import com.itcast.basic.designpatterntype.factorytype.abstractfactory.abstractfactory.AbstractFactory;
import com.itcast.basic.designpatterntype.factorytype.abstractfactory.abstractproduct.ProductE;
import com.itcast.basic.designpatterntype.factorytype.abstractfactory.abstractproduct.ProductF;
import com.itcast.basic.designpatterntype.factorytype.abstractfactory.product.CMSProductE;
import com.itcast.basic.designpatterntype.factorytype.abstractfactory.product.CMSProductF;

/**
 * Created by qfl on 16/6/2.
 */
public class ProductFactoryB implements AbstractFactory {
    @Override
    public ProductE createProductE() {
        return new CMSProductE();
    }

    @Override
    public ProductF createProductF() {
        return new CMSProductF();
    }
}
