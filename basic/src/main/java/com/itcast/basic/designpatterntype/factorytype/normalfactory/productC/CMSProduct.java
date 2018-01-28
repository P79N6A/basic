package com.itcast.basic.designpatterntype.factorytype.normalfactory.productC;

/**
 * Created by qfl on 16/6/2.
 */
public class CMSProduct extends AbstractProcuct {
    public CMSProduct() {
        System.out.println("进行系统的初始化工作");
    }

    public void operateCore() {
        System.out.println("进行CMS核心业务操作");
    }
}
