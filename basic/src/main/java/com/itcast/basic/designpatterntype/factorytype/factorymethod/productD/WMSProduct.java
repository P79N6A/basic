package com.itcast.basic.designpatterntype.factorytype.factorymethod.productD;

/**
 * Created by qfl on 16/6/2.
 */
public class WMSProduct extends AbstractProcuct {

    public WMSProduct() {
        System.out.println("进行系统的初始化工作");
    }

    public void operateCore() {
        System.out.println("进行WMS核心业务操作");
    }
}
