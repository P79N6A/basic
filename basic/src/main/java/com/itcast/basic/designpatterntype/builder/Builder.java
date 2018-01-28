package com.itcast.basic.designpatterntype.builder;

/**
 * Created by qfl on 16/6/3.
 */
public class Builder {
    public Builder() {
        new PartA().build();
        new PartB().build();
    }

    public Product getProduct() {
        return new Product();
    }
}
