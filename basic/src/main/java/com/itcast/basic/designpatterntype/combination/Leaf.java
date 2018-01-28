package com.itcast.basic.designpatterntype.combination;

/**
 * Created by qfl on 16/6/3.
 */
public class Leaf implements Combination {
    @Override
    public void add(Combination combination) {
        throw new IllegalArgumentException("叶子不能进行该操作");
    }

    @Override
    public void remove(Combination combination) {
        throw new IllegalArgumentException("叶子不能进行该操作");
    }

    @Override
    public void operate() {
        System.out.println("进行叶子操作");
    }
}
