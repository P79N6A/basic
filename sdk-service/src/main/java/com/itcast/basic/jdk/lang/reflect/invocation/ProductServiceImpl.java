package com.itcast.basic.jdk.lang.reflect.invocation;

/**
 * Created by treey.qian on 2018/2/1.
 */
public class ProductServiceImpl implements ProductService {
    @Override
    public void createProduct() {
        System.out.println("invoke ProductService createProduct");
    }
}
