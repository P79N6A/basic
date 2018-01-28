package com.itcast.basic.designpatterntype.factorytype.nofactory.productB;

/**
 * Created by qfl on 16/6/2.
 */
public class WMSProduct extends AbstractProcuct{

    public WMSProduct() {
        System.out.println("进行系统的初始化工作");
    }

    public void operateWMSCore() {
        System.out.println("进行WMS核心业务操作");
    }
}
