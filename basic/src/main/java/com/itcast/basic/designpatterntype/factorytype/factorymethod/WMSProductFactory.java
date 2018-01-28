package com.itcast.basic.designpatterntype.factorytype.factorymethod;

import com.itcast.basic.designpatterntype.factorytype.factorymethod.productD.WMSProduct;

/**
 * Created by qfl on 16/6/2.
 */
public class WMSProductFactory {
    public WMSProduct createWMSProduct() {
        return new WMSProduct();
    }
}
