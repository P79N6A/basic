package com.itcast.basic.designpatterntype.factorytype.abstractfactory.product;

import com.itcast.basic.designpatterntype.factorytype.abstractfactory.abstractproduct.ProductE;

/**
 * Created by qfl on 16/6/2.
 */
public class CMSProductE implements ProductE {
    @Override
    public void operateProductECore() {
        System.out.println("operate CMSProductE");
    }
}
