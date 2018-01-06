package com.itcast.basic.designpatterntype.strategy.impl;

import com.itcast.basic.designpatterntype.strategy.service.Strategy;

public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}