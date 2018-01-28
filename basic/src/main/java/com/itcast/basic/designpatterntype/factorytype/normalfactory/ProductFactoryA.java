package com.itcast.basic.designpatterntype.factorytype.normalfactory;

import com.itcast.basic.designpatterntype.factorytype.normalfactory.productC.Product;

/**
 * Created by qfl on 16/6/2.
 */
public class ProductFactoryA {
    public static <T extends Product> T createProduct(Class<T> classes) {
        T product = null;
        try {
            System.out.println("进行系统的初始化工作");
            product = (T) classes.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return product;
    }
}
