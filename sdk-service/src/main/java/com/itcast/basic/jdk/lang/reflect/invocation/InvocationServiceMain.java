package com.itcast.basic.jdk.lang.reflect.invocation;

/**
 * Created by treey.qian on 2018/2/1.
 */
public class InvocationServiceMain {
    public static void main(String[] args) {
        try {
            System.out.println("enter into InvocationServiceMain");
            ProductService productService = new ProductServiceImpl();
            ProductService productServiceProxy = (ProductService) ProductServiceProxy.newProxyInstance(productService);
            productServiceProxy.createProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
