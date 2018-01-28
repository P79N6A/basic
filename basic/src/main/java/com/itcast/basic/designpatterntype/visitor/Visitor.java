package com.itcast.basic.designpatterntype.visitor;

/**
 * Created by qfl on 16/6/3.
 */
public class Visitor {
    public void compress(Service service) {
        System.out.println("执行默认的操作");
    }

    public void compress(SaveService service) {
        System.out.println("执行保存的操作");
    }

    public void compress(PopService service) {
        System.out.println("执行取款的操作");
    }
}
