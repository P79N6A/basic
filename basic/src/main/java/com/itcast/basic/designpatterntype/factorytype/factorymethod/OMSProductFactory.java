package com.itcast.basic.designpatterntype.factorytype.factorymethod;

import com.itcast.basic.designpatterntype.factorytype.factorymethod.productD.OMSProduct;

/**
 * Created by qfl on 16/6/2.
 */
public class OMSProductFactory {
    public OMSProduct createOMSProduct() {
        return new OMSProduct();
    }
}
