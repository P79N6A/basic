package com.itcast.basic.designpatterntype.builder;

/**
 * Created by qfl on 16/6/3.
 */
public class PartA implements Part {
    @Override
    public void build() {
        System.out.println("创建PartA");
    }
}
