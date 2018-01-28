package com.itcast.basic.designpatterntype.factorytype.factorymethod;

import com.itcast.basic.designpatterntype.factorytype.factorymethod.productD.CMSProduct;

/**
 * Created by qfl on 16/6/2.
 */

public class CMSProductFactory implements Factory {
    public CMSProduct createProduct() {
        return new CMSProduct();
    }
}
