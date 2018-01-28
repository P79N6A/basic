package com.itcast.basic.designpatterntype.strategy;

/**
 * Created by qfl on 16/6/3.
 */
public class ReduceOperate implements Operate<Integer> {
    @Override
    public Integer operate(Integer a, Integer b) {
        return a - b;
    }
}
