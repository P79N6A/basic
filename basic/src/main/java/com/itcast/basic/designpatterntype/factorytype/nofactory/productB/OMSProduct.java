package com.itcast.basic.designpatterntype.factorytype.nofactory.productB;

/**
 * Created by qfl on 16/6/2.
 */
public class OMSProduct extends AbstractProcuct{
    public OMSProduct() {
        System.out.println("进行系统的初始化工作");
    }

    public void operateOMSCore() {
        System.out.println("进行OMS核心业务操作");
    }
}
