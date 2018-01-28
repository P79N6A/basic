package com.itcast.basic.designpatterntype.factorytype.normalfactory.productC;

/**
 * Created by qfl on 16/6/2.
 */
public abstract class AbstractProcuct implements Product {
    public void initManage() {
        System.out.println("连接管理器");
    }

    public void close() {
        System.out.println("释放系统资源");
    }

}
