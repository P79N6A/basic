package com.itcast.basic.designpatterntype.factorytype.normalfactory;

import com.itcast.basic.designpatterntype.factorytype.factorymethod.productD.CMSProduct;
import com.itcast.basic.designpatterntype.factorytype.factorymethod.productD.OMSProduct;
import com.itcast.basic.designpatterntype.factorytype.factorymethod.productD.WMSProduct;

/**
 * Created by qfl on 16/6/2.
 */
public class ProductFactoryB {
    public static CMSProduct createCMSProduct() {
        return new CMSProduct();
    }

    public static OMSProduct createOMSProduct() {
        return new OMSProduct();
    }

    public static WMSProduct createWMSProduct() {
        return new WMSProduct();
    }
}
