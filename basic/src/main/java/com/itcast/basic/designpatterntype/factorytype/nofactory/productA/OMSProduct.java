package com.itcast.basic.designpatterntype.factorytype.nofactory.productA;

/**
 * Created by qfl on 16/6/2.
 */
public class OMSProduct {
    public OMSProduct() {
        System.out.println("进行系统的初始化工作");
    }

    public void initManage() {
        System.out.println("连接管理器");
    }

    public void operateOMSCore() {
        System.out.println("进行OMS核心业务操作");
    }

    public void close() {
        System.out.println("释放系统资源");
    }
}
