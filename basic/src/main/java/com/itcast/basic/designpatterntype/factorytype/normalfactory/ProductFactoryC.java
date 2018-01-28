package com.itcast.basic.designpatterntype.factorytype.normalfactory;

import com.itcast.basic.designpatterntype.factorytype.factorymethod.productD.CMSProduct;
import com.itcast.basic.designpatterntype.factorytype.factorymethod.productD.OMSProduct;
import com.itcast.basic.designpatterntype.factorytype.factorymethod.productD.Product;
import com.itcast.basic.designpatterntype.factorytype.factorymethod.productD.WMSProduct;

/**
 * Created by qfl on 16/6/2.
 */
public class ProductFactoryC {
    public static Product createProduct(String type) {
        Product product = null;
        switch (type) {
            case "CMS":
                product = new CMSProduct();
                break;
            case "WMS":
                product = new WMSProduct();
                break;
            case "OMS":
                product = new OMSProduct();
                break;
        }
        return product;
    }
}
